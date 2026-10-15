# KuroToon UI Foundation — Phase 1

**Status:** Implementation contract for the first visual-design pass  
**Scope:** Global app shell, shared visual language, and Home screen direction  
**Platform:** Native Android / Jetpack Compose  
**Product rule:** The existing app is the foundation. Evolve it in small, testable steps; do not replace the app with a web prototype or rebuild working reader/source infrastructure without a demonstrated need.

## 1. Product identity

KuroToon should feel like a personal, atmospheric manga-reading space: polished, quiet when reading, expressive when exploring, and unmistakably its own product. Use the already-approved KuroToon brand assets and references as the source of truth. Never invent a replacement for the official Kuru mascot or claim generated artwork is the supplied mascot.

### Core visual tokens

Use the existing KuroToon Material color scheme as the initial source of truth and refine it only when supported by the approved references.

- **Space background:** near-black with a subtle violet undertone.
- **Primary text:** high-contrast soft white.
- **Secondary text:** muted lavender-grey; maintain accessible contrast.
- **Signature accent:** restrained crimson / rose for selected destinations, active progress, and important actions.
- **Cosmic support:** violet for atmosphere and focused highlights.
- **Gold:** rare emphasis for achievements or special cosmetics, never ordinary controls.
- **Surfaces:** layered dark cards with clear separation; avoid outlining every component.
- **Artwork:** covers and manga pages should be the visual focus, not decorative UI effects.
- **Shape:** consistent rounded cards and touch targets; avoid excessive pill shapes.
- **Motion:** quick, subtle feedback; all decorative effects must respect reduced motion and never delay interaction.

Do not force cyan/blue as the primary brand color. Do not use a heavy glow behind every item. Do not place decorative particles over manga artwork or dense text.

## 2. Required primary navigation

The five primary destinations, in this order, are:

1. **Home**
2. **Browse**
3. **Shop**
4. **Library**
5. **Me**

Do not expose Repositories, Reader Studio, settings, history, or updates as additional primary tabs. Place those features within the appropriate destination and existing navigation flows.

### Destination responsibilities

- **Home:** continue reading, recent activity, curated discovery, trending or featured content when real data is available, and a useful first-run state.
- **Browse:** cross-source discovery, search, genre/tag/language/source filters, sorting, and clear source provenance.
- **Shop:** free-first cosmetics and personalization. No fake prices, fake scarcity, paid checkout, or premium-only controls.
- **Library:** saved series, unread items, updates, favourites, categories, sorting, filters, and reading progress.
- **Me:** profile and truthful stats, achievements where persisted, appearance and reader preferences, app information, and settings.
- **Repositories:** Me → Settings → Sources → Repositories.
- **Reader Studio:** opened from reader controls/settings; it is not a main tab.

The current upstream-derived tab model may not match this product navigation. Before changing it, trace tab objects, deep links, back behavior, saved state, onboarding, widgets, and tests. Preserve existing working behavior and migrate navigation in a focused implementation PR.

## 3. Global app shell

The app shell should provide:

- A consistent top-level content inset and system-bar treatment.
- One shared typography and spacing rhythm.
- Consistent icon sizing and accessible touch targets.
- A bottom navigation bar on compact phones; preserve the existing adaptive rail behavior on larger screens unless testing reveals a concrete issue.
- A clear selected destination state using a restrained crimson/rose treatment and icon/label state—not color alone.
- Correct back-stack behavior when moving between destinations and opening detail screens.
- Safe-area / edge-to-edge handling that does not cover content.
- No web prototype embedded in the APK and no prototype presented as the shipped app.

Do not redesign every destination in this phase. Establish reusable conventions first, then apply them incrementally.

## 4. Home screen specification

### Header

- KuroToon identity and approved brand asset, at a measured scale.
- Search action that routes to Browse/search.
- Optional activity/notification affordance only if it opens a real destination.
- Avoid a tall banner that pushes the user's library below the fold.

### Section order

1. **Continue Reading** — first when there is in-progress reading. Show cover, title, chapter/episode, and progress only when known. Tapping resumes the actual reader position.
2. **Recently Read / Your Library** — concise horizontal cover row based on real local library/history data.
3. **Discover** — source-backed recommendations or featured content. Make provenance available and handle unavailable sources.
4. **Genres and collections** — derived from trustworthy metadata. Do not invent genre labels when metadata is absent; any inferred classification must be treated as uncertain and correctable.
5. **New and updated chapters** — show only when the underlying update data is available and refresh behavior is implemented.

### Empty, loading, and error states

- **Fresh install:** welcoming, useful guidance to browse or configure a source; no fabricated reading history or trending numbers.
- **No sources:** explain that sources are configured by the user and link to Me → Settings → Sources → Repositories.
- **No history:** replace Continue Reading with a compact invitation to discover a first series.
- **Loading:** stable skeletons that do not jump around when data arrives.
- **Source failure:** show a concise recoverable state; do not make one failed source blank the entire Home screen.
- **Offline:** preserve cached/local library information where available and distinguish it from live data.

### Content cards

- Cover art remains dominant.
- Title is readable and clamped without hiding useful identity.
- Chapter and progress labels are displayed only when real.
- Duplicate source entries should not be silently merged into one inaccessible item. If KuroToon identifies a likely common series, retain source alternatives and let users inspect or correct the match.
- Images must have meaningful accessibility descriptions where appropriate; actions must have clear labels.

## 5. Shared component contract

Prefer a small set of reusable Compose components over screen-specific copies:

- KuroToonScreenScaffold (or adapt the existing scaffold if it already serves the same purpose).
- KuroToonSectionHeader.
- KuroToonSeriesCard variants for horizontal and grid layouts.
- KuroToonProgressIndicator for real reading progress.
- KuroToonEmptyState.
- KuroToonLoadingState.
- KuroToonErrorState with retry when retry is supported.
- Shared spacing, corner, and touch-target constants where they improve consistency.

Before adding a component, inspect existing equivalents and extend them where practical. Do not introduce a second design system alongside Material 3.

## 6. Repository and metadata behavior that affects the UI

Repository discovery and series organization are separate concerns:

1. Repositories expose extension/source metadata and update information.
2. Installed sources provide series and chapter data through the source integration layer.
3. A metadata normalization layer can compare title variants, creators, cover similarity, descriptions, languages, genres, and other available evidence.
4. A unified series record may link multiple source entries while preserving each source's identity and availability.
5. Genre/category organization should prefer source-provided metadata. Inference is a fallback, must be confidence-aware, and must remain correctable.
6. Repository ingestion must not blindly execute third-party repository content or gain unrestricted access to app state, credentials, local files, or native APIs.

The UI should display provenance and uncertainty where it matters. It should never claim that metadata is complete across all repositories.

## 7. Non-goals for Phase 1

- No replacement web prototype.
- No fake account sync, cloud backup, analytics, ratings, recommendations, or fabricated sample history presented as real user data.
- No implementation of the full extension sandbox, metadata AI, dubbing engine, atmospheric audio engine, or Kuro Flow in the Home UI PR.
- No broad package/namespace migration as part of a visual-only change.
- No removal of required copyright notices, license texts, or attribution.
- No global rewrite of the existing reader/source engine.

## 8. Acceptance checklist

- [ ] The five destinations are Home, Browse, Shop, Library, Me.
- [ ] Repositories remain under Me → Settings → Sources → Repositories.
- [ ] Existing navigation/back behavior is understood and tested before changing routes.
- [ ] KuroToon theme remains consistent with approved brand references.
- [ ] Home content is driven by actual available app data; no fake stats or activity.
- [ ] Empty, loading, offline, and source-error states are specified.
- [ ] The UI remains usable with reduced motion and on lower-end phones.
- [ ] Existing source, library, reader, and progress functionality is not regressed.
- [ ] Formatting, unit tests, and Android build are run for implementation changes.
- [ ] Device behavior is not claimed verified unless a physical/emulated device test was actually performed.

## 9. Implementation sequence

1. **Foundation:** reconcile navigation requirements, shared design tokens, and global app shell.
2. **Home:** implement real-data states and reusable cards/sections.
3. **Browse:** search, filters, sorting, and source provenance.
4. **Library and series detail:** saved-state filters, progress, chapter/source alternatives.
5. **Reader canvas:** preserve reliable reading behavior and add the settings entry point.
6. **Reader Studio:** layout, gestures, atmosphere, voice, then advanced Kuro Flow surfaces.
7. **Me, settings, repositories, and Shop:** connect screens to real state and avoid placeholder claims.
8. **Integration:** test navigation, persistence, accessibility, performance, and APK build.

Each implementation phase should be delivered as a focused pull request with its own build/test result. A design document is not evidence that the described UI or features are already implemented.
