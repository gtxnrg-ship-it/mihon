package eu.kanade.tachiyomi.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import dev.zacsweers.metrox.viewmodel.metroViewModel
import eu.kanade.presentation.history.HistoryUiModel
import eu.kanade.presentation.home.KuroToonHomeEmptyState
import eu.kanade.presentation.home.KuroToonHomeSectionHeader
import eu.kanade.presentation.util.Tab
import eu.kanade.presentation.util.formatChapterNumber
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.ui.browse.BrowseTab
import eu.kanade.tachiyomi.ui.history.HistoryViewModel
import eu.kanade.tachiyomi.ui.library.LibraryTab
import eu.kanade.tachiyomi.ui.library.LibraryViewModel
import eu.kanade.tachiyomi.ui.manga.MangaScreen
import eu.kanade.tachiyomi.ui.reader.ReaderActivity

data object KuroToonHomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Home",
            icon = painterResource(R.drawable.ic_kurotoon_home),
        )

    override suspend fun onReselect(navigator: Navigator) = Unit

    @Composable
    override fun Content() {
        val tabNavigator = LocalTabNavigator.current
        val navigator = LocalNavigator.currentOrThrow
        val context = LocalContext.current
        val libraryViewModel = metroViewModel<LibraryViewModel>()
        val libraryState by libraryViewModel.state.collectAsStateWithLifecycle()
        val libraryItems = libraryState.libraryData.favorites.take(6)
        val historyViewModel = metroViewModel<HistoryViewModel>()
        val historyState by historyViewModel.state.collectAsStateWithLifecycle()
        val recentItems = historyState.list.orEmpty()
            .filterIsInstance<HistoryUiModel.Item>()
            .take(4)
        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "KuroToon",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                )
                Text(
                    text = "Your next chapter starts here.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 4.dp),
                )

                KuroToonHomeSectionHeader(
                    title = "Continue reading",
                    subtitle = if (historyState.list == null) {
                        "Loading your reading history"
                    } else {
                        "Your most recently read chapters"
                    },
                )
                when {
                    historyState.list == null -> {
                        Text(
                            text = "Loading your reading history…",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 12.dp),
                        )
                    }
                    recentItems.isEmpty() -> {
                        KuroToonHomeEmptyState(
                            title = "Nothing to resume yet",
                            message = "Open a series and read a chapter. Your recent reading will appear here.",
                            actionLabel = "Browse series",
                            onAction = { tabNavigator.current = BrowseTab },
                        )
                    }
                    else -> {
                        recentItems.forEach { recent ->
                            val item = recent.item
                            Card(
                                onClick = {
                                    context.startActivity(
                                        ReaderActivity.newIntent(context, item.mangaId, item.chapterId),
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                ),
                            ) {
                                Column(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                ) {
                                    Text(
                                        text = item.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSurface,
                                    )
                                    Text(
                                        text = if (item.chapterNumber > -1) {
                                            "Chapter ${formatChapterNumber(item.chapterNumber)} · Tap to continue"
                                        } else {
                                            "Recently read · Tap to continue"
                                        },
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                }
                            }
                        }
                    }
                }

                KuroToonHomeSectionHeader(
                    title = "Your library",
                    subtitle = if (libraryState.isLoading) {
                        "Loading your saved series"
                    } else {
                        "${libraryState.libraryData.favorites.size} saved series"
                    },
                    actionLabel = "Open library",
                    onAction = { tabNavigator.current = LibraryTab },
                )
                when {
                    libraryState.isLoading -> {
                        Text(
                            text = "Loading your library…",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 12.dp),
                        )
                    }
                    libraryItems.isEmpty() -> {
                        KuroToonHomeEmptyState(
                            title = "Build your library",
                            message = "Save series from your available sources to keep them together here.",
                            actionLabel = "Go to library",
                            onAction = { tabNavigator.current = LibraryTab },
                        )
                    }
                    else -> {
                        libraryItems.forEach { item ->
                            Card(
                                onClick = {
                                    navigator.push(MangaScreen(item.libraryManga.manga.id))
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                ),
                            ) {
                                Column(
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                ) {
                                    Text(
                                        text = item.libraryManga.manga.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSurface,
                                    )
                                    Text(
                                        text = when (item.unreadCount) {
                                            0L -> item.sourceName
                                            1L -> "1 unread chapter • ${item.sourceName}"
                                            else -> "${item.unreadCount} unread chapters • ${item.sourceName}"
                                        },
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                }
                            }
                        }
                        if (libraryState.libraryData.favorites.size > libraryItems.size) {
                            Button(
                                onClick = { tabNavigator.current = LibraryTab },
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            ) {
                                Text("View all ${libraryState.libraryData.favorites.size} series")
                            }
                        }
                    }
                }

                KuroToonHomeSectionHeader(
                    title = "Discover",
                    subtitle = "Explore series from your installed sources",
                )
                Button(
                    onClick = { tabNavigator.current = BrowseTab },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                ) {
                    Text("Explore sources")
                }
            }
        }
    }
}

data object KuroToonShopTab : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Shop",
            icon = painterResource(R.drawable.ic_kurotoon_shop),
        )

    override suspend fun onReselect(navigator: Navigator) = Unit

    @Composable
    override fun Content() {
        Scaffold { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text("KuroToon Shop", style = MaterialTheme.typography.headlineLarge)
                Text(
                    text = "Personalization, without pressure.",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                KuroToonHomeEmptyState(
                    title = "Cosmetics are not available yet",
                    message = "Themes, avatars, frames, and stickers are planned. " +
                        "Nothing is for sale or locked behind a purchase in this preview.",
                )
            }
        }
    }
}
