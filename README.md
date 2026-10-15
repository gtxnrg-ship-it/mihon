# 🌌 KuroToon

<p align="center">
  <strong>Your manga universe. Your way.</strong><br/>
  A cozy cosmic home for your next story. 🐈‍⬛✨
</p>

<p align="center">
  <a href="https://kurotoon-hub.lovable.app/"><strong>🌐 Open the KuroToon Website</strong></a>
  ·
  <a href="https://github.com/gtxnrg-ship-it/mihon/releases/latest"><strong>📦 Latest APK Release</strong></a>
  ·
  <a href="https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml"><strong>🛠️ Latest Build</strong></a>
</p>

<p align="center">
  <a href="https://github.com/gtxnrg-ship-it/mihon/releases/latest"><img alt="Latest release" src="https://img.shields.io/github/v/release/gtxnrg-ship-it/mihon?display_name=tag&label=latest%20release&color=ff477e" /></a>
  <a href="https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml"><img alt="Build status" src="https://img.shields.io/github/actions/workflow/status/gtxnrg-ship-it/mihon/build.yml?label=build&color=9461ff" /></a>
  <a href="./LICENSE"><img alt="License: Apache-2.0" src="https://img.shields.io/github/license/gtxnrg-ship-it/mihon?label=license" /></a>
</p>

---

## 💖 Welcome to KuroToon

KuroToon is an independent, Android-first manga reading project with a big ambition: make discovering, reading, and organizing stories feel personal, smooth, and a little magical. The long-term vision combines a polished reader, source choice, a thoughtful library, cosmic customization, and an easy way to get new versions.

**The live website is the prototype and showcase. The Android APK is the native app.** They are related parts of the same project, but a feature shown in the prototype is not automatically available in the Android app until it has been implemented and tested there.

> [!IMPORTANT]
> **Development status:** KuroToon is actively being built. The latest-release link below is the permanent place to check for a published APK. If no release has been published yet, the link may show that no release is available. We will not label an unbuilt or untested APK as a finished release.

## 🚀 Get KuroToon

### 📱 Android app (APK)

**[➡️ Go to the latest KuroToon APK release](https://github.com/gtxnrg-ship-it/mihon/releases/latest)**

When a release is published, open its assets and download the APK that matches your device. If you're unsure, choose the **universal APK** when one is provided. For most modern Android phones using 64-bit ARM, the `arm64-v8a` build is usually the right match.

**No published APK yet?** You can check whether a fresh build artifact is available on the [Build & Test Actions page](https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml). Open the newest successful run on the main branch and look for its APK artifact. Actions artifacts are temporary build outputs for testing; they are not the same as a stable, published release and may require signing/installation checks.

**Install on Android**
1. Download the APK to your phone.
2. Open it from your Downloads folder.
3. If Android asks, allow your browser or file manager to install unknown apps for this installation.
4. Review the Android installer and confirm installation.

Only install APKs from this repository's official release page or trusted project build runs. Android may block an update if it was signed with a different key from the version already installed. Back up important reading data before testing development builds.

### 🌐 Website and prototype

**[✨ Open the live KuroToon prototype](https://kurotoon-hub.lovable.app/)**

Explore the current web prototype on your phone or computer. It is the visual reference for KuroToon's design direction. Some screens and interactions may still be prototype-only while the native Android implementation catches up.

### 🧪 Development builds

**[View recent builds on GitHub Actions](https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml)**

Build artifacts are useful for trying work-in-progress changes. They can expire, may not be signed for long-term upgrades, and should not be mistaken for stable releases.

---

## 🔄 How updates will work

We want updating KuroToon to be simple:

1. A new version is built and checked.
2. The project publishes the version and release notes on the [GitHub Releases page](https://github.com/gtxnrg-ship-it/mihon/releases).
3. The **Latest APK Release** link at the top always points to the newest published release—no need to hunt through old versions.
4. The native app's planned update experience will check for a newer compatible release, show the version and notes, and let you choose **Update**. Android will still handle the installation confirmation.

**Important:** The website and README links can point to the newest published release automatically. In-app automatic update checking is a separate native feature and must be implemented and tested before we claim it works. Updates also require a consistent application ID, version-code progression, and a stable signing key.

## 🌠 What KuroToon is aiming for

- **Home:** continue reading, recent activity, and featured stories.
- **Browse:** search, sort, and filter titles across enabled sources.
- **Shop:** free-first cosmetics and personalization; no paid checkout in the current project.
- **Library:** reading lists, bookmarks, favourites, history, and progress.
- **Me:** profile, settings, appearance, source/repository management, privacy, and app information.
- **Liquid interactions:** gentle water-like ripples and particle glints, with controls for intensity and reduced motion.
- **Reader improvements:** reliable page navigation and progress first, with optional atmosphere and other enhancements as they become real features.

These are goals and roadmap items—not a claim that every item is already implemented.

## 🆓 Always free at this stage

KuroToon is **fully free to use right now**. No current feature is intended to be locked behind a subscription or paywall. There is no active payment checkout, paid tier, or premium-only feature in the current plan. A possible future payment option is only a possibility, not a current offering.

## 🔌 Sources and content

KuroToon is a reader client; it does not host manga or promise that a particular third-party title will always be available. Users choose the sources they use. Source providers operate independently and may have their own terms, privacy practices, and content rights. Please use sources lawfully and respect the rights of creators and publishers.

Repository management is intended to live under **Me → Settings → Sources → Repositories**, not as another main navigation tab. Installing a repository must not be treated as blanket endorsement of everything it provides.

## 🛡️ Privacy, terms, and project documents

- [Terms of Service (draft)](./docs/TERMS_OF_SERVICE.md)
- [Privacy Notice (draft)](./docs/PRIVACY_NOTICE.md)
- [Interaction design and Me-section direction](./docs/KUROTOON_INTERACTION_DESIGN.md)
- [Product roadmap](./docs/KUROTOON_PRODUCT_ROADMAP.md)

The legal documents are drafts and must be checked against the actual app behavior and reviewed before being treated as final legal terms.

## 🧰 Build from source

Use the Java version declared in `.github/.java-version` and the checked-in Gradle wrapper.

```bash
./gradlew assembleRelease -Pdist=ci
```

The [Build & Test workflow](./.github/workflows/build.yml) runs formatting checks, unit tests, SQLDelight migration verification, and an Android release build. CI success is not the same as testing the APK on a physical device.

## 📜 Open-source credits

KuroToon is an independent project and is not an official release of any upstream project. Portions of the codebase are derived from the **Mihon open-source project**. Applicable upstream copyright and attribution notices and the Apache License 2.0 are retained in this repository; see [LICENSE](./LICENSE). Third-party components may have separate terms. This attribution is included for license compliance and does not imply that KuroToon is the upstream product.

## 🤝 Contributing

Please review [CODE_OF_CONDUCT.md](./CODE_OF_CONDUCT.md) and [CONTRIBUTING.md](./CONTRIBUTING.md). Roadmap items should only be marked complete after implementation and verification.

---

<p align="center">
  <strong>KuroToon — every season, every story. Always with Kuru. 💜</strong><br/>
  <sub>Find your next world. Keep your reading yours.</sub>
</p>
