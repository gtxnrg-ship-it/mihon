<div align="center">

# KuroToon

### Your manga universe. Your way. 🌌

A community-driven Android manga, webtoon, and comic reader built on the open-source Mihon project, with a distinct KuroToon identity and a cosmic, character-led design direction.

[![License: Apache-2.0](https://img.shields.io/github/license/gtxnrg-ship-it/mihon?label=License&color=9461ff)](./LICENSE)
[![Build](https://img.shields.io/github/actions/workflow/status/gtxnrg-ship-it/mihon/build.yml?label=Build)](./.github/workflows/build.yml)

</div>

---

## About KuroToon

KuroToon is an Android reader project focused on a polished reading experience, thoughtful customization, and a recognizable cosmic visual identity. It builds on the Mihon open-source codebase; upstream functionality, notices, and license obligations are retained.

**This repository is an active development fork.** Features listed as planned are not necessarily implemented in the current APK. Check the roadmap and pull requests for verified progress.

## Current foundation

- Android application identity set to **KuroToon** (`app.kurotoon`).
- Mihon reader foundation retained while KuroToon-specific changes are developed separately.
- Existing reader, library, and source functionality from the upstream foundation remains the starting point.
- Android release build workflow can build an APK and upload it as a GitHub Actions artifact when the workflow succeeds.

## Design direction

KuroToon's visual system is intended to use deep space backgrounds, cosmic purple and blue, restrained pink/red highlights, and small gold accents. Kuro-chan—the established black-haired, cat-eared mascot—is the source of truth for the brand. Her approved artwork should be integrated from the original asset files; replacement artwork must not be presented as the official mascot.

Planned product areas:

- **Home** — continue reading, recent activity, featured and trending series.
- **Browse** — search, sorting, genre/language filters, and source-aware discovery.
- **Shop** — cosmetic stickers, avatars, frames, banners, and themes; no pay-to-read mechanics.
- **Library** — reading lists, categories, bookmarks, history, and unread updates.
- **Me** — profile, achievements, customization, settings, and privacy.
- **Sources & repositories** — managed under Me → Settings → Sources → Repositories, not as a separate bottom-navigation tab.

## Roadmap

1. Establish independent app identity and branding foundation.
2. Apply KuroToon theme and approved Kuro-chan assets.
3. Redesign the primary navigation and Home/Browse/Shop/Library/Me surfaces.
4. Improve source/repository management and cross-source discovery.
5. Develop optional reader atmosphere features, with clear controls for sound, haptics, and AI-assisted tools.
6. Validate installation, reading, backups, permissions, and performance before calling a build ready.

See the [KuroToon product blueprint](https://github.com/gtxnrg-ship-it/Kurotoon/blob/main/docs/PRODUCT_BLUEPRINT.md) for the wider product direction. Planned features are not a promise that they are already present in this codebase.

## Download an APK

**No tested KuroToon APK is being advertised by this README yet.** When a build completes successfully, open the repository's [Actions](https://github.com/gtxnrg-ship-it/mihon/actions) page, select the successful **Build & Test** run for the relevant branch or pull request, and download the APK artifact named similar to `arm64-v8a-<commit-sha>`. Extract the APK from the downloaded ZIP and install it on a compatible Android device.

- The workflow builds a release APK for **arm64-v8a**; it is not a universal APK for every processor.
- A successful CI build is not the same as a real-device installation and reading test.
- Do not install an artifact from a failed or untrusted workflow run.

## Building locally

Use the project's Gradle wrapper and follow the existing [contributing guide](./CONTRIBUTING.md). A typical release build is:

    ./gradlew assembleRelease -Pdist=ci

The CI workflow also runs formatting checks, unit tests, and SQLDelight migration verification before packaging. Use the Java version declared in `.github/.java-version`.

## Open source, credits, and licensing

KuroToon is based on the [Mihon open-source project](https://github.com/mihonapp/mihon). This fork must retain the upstream license, copyright notices, and applicable attributions. KuroToon is an independent community project and is not an official Mihon release.

The code is licensed under the Apache License, Version 2.0; see [LICENSE](./LICENSE). Third-party components may have their own notices and terms.

## Content disclaimer

KuroToon does not host manga, comics, or other reading content. Availability and legality of third-party sources depend on the source and the user's location. Users are responsible for ensuring they have the rights to access the content they read. No affiliation with third-party content providers is implied.

## Contributing

Changes are welcome. Please review [CODE_OF_CONDUCT.md](./CODE_OF_CONDUCT.md) and [CONTRIBUTING.md](./CONTRIBUTING.md), and open an issue to discuss substantial changes before submitting a pull request.

---

<div align="center">

**KuroToon — find your next world.** ✨

</div>
