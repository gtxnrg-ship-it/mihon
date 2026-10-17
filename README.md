# 🌌 KuroToon

<p align="center">
  <strong>Your manga universe. Your way.</strong><br/>
  A cozy cosmic home for your next story. 🐈‍⬛✨
</p>

<p align="center">
  <a href="https://github.com/gtxnrg-ship-it/mihon/releases/latest/download/Crochan.apk"><strong>📦 Download Crochan APK</strong></a>
  ·
  <a href="https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml"><strong>🛠️ Build Status & Test APKs</strong></a>
  ·
  <a href="https://github.com/gtxnrg-ship-it/mihon/releases"><strong>📝 All Releases</strong></a>
</p>

<p align="center">
  <a href="https://github.com/gtxnrg-ship-it/mihon/releases/latest"><img alt="Latest release" src="https://img.shields.io/github/v/release/gtxnrg-ship-it/mihon?display_name=tag&label=latest%20release&color=ff477e" /></a>
  <a href="https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml"><img alt="Build status" src="https://img.shields.io/github/actions/workflow/status/gtxnrg-ship-it/mihon/build.yml?label=build&color=9461ff" /></a>
  <a href="./LICENSE"><img alt="License: Apache-2.0" src="https://img.shields.io/github/license/gtxnrg-ship-it/mihon?label=license" /></a>
</p>

---

## 💖 Welcome to KuroToon

KuroToon is an independent, Android-first manga reader with a big ambition: make discovering, reading, and organizing stories feel personal, smooth, and a little magical. The goal is a polished native app with source choice, a thoughtful library, cosmic customization, and a straightforward way to get updates.

> [!IMPORTANT]
> **Development status:** KuroToon is actively being built. This repository is the home of the Android application. Download only a release that has actually been published below; if no release is available yet, the first official APK is not published. We won't pretend a prototype or an unverified build is the finished app.

## 📱 Get KuroToon for Android

### 📦 Latest official APK

**[✨ Download Crochan.apk directly](https://github.com/gtxnrg-ship-it/mihon/releases/latest/download/Crochan.apk)**

This link is configured to download the universal APK directly, without opening the release page first. It will work once the first non-draft, published release containing `Crochan.apk` is available. At present, the repository has no published APK asset, so we must not present the download as live yet.

When the APK is available, tap the link, open the downloaded `Crochan.apk`, and confirm Android's installation prompt if shown.

Only install APKs from this repository's official Releases page. Android requires an update to be signed with the same signing key as the installed version. Back up important reading data before testing development builds.

### 🧪 Test builds for development

**[Open Build & Test on GitHub Actions](https://github.com/gtxnrg-ship-it/mihon/actions/workflows/build.yml)**

Development builds help us test changes before an official release. After a successful run, download the `KuroToon-test-…` artifact and extract the APK from the ZIP. These artifacts are for testing, can expire, and are not the same as a stable published release.

---

## 🔄 New versions and updates

The goal is simple: **one app, one reliable place for the newest version.**

1. Code changes are built and checked.
2. A version is prepared with release notes and APK files.
3. The release is reviewed and published on [GitHub Releases](https://github.com/gtxnrg-ship-it/mihon/releases).
4. The **Latest official APK** link at the top automatically leads to the newest published release.

The native app's in-app update checker is a separate feature and must be implemented and tested before we claim it works. When available, it should show the new version and notes and offer an **Update** action. Android will still show its installation confirmation; apps cannot silently install ordinary APK updates without the appropriate privileged distribution setup.

---

## 🌠 The KuroToon vision

- **Home:** continue reading, recent activity, and featured stories.
- **Browse:** search, sort, and filter titles across enabled sources.
- **Shop:** free-first cosmetics and personalization, with no paid checkout in the current plan.
- **Library:** reading lists, bookmarks, favourites, history, and progress.
- **Me:** profile, settings, appearance, source/repository management, privacy, and app information.
- **Liquid interactions:** gentle water-like ripples and particle glints, with controls for intensity and reduced motion.
- **Reader:** reliable navigation and progress first, with optional atmosphere and other enhancements as they become working features.

These are product goals and roadmap items, not a claim that every item is already implemented.

## 🆓 Fully free right now

KuroToon is **fully free to use at this stage**. No current feature is intended to be locked behind a subscription or paywall. There is no active payment checkout, paid tier, or premium-only feature in the current plan. A possible future payment option is only a possibility, not a current offering.

## 🔌 Sources and content

KuroToon is a reader client; it does not host manga or promise that a particular third-party title will always be available. Users choose the sources they use. Source providers operate independently and may have their own terms, privacy practices, and content rights. Please use sources lawfully and respect the rights of creators and publishers.

Repository management is intended to live under **Me → Settings → Sources → Repositories**, not as another main navigation tab. Adding a repository does not mean KuroToon endorses everything it provides.

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

The [Build & Test workflow](./.github/workflows/build.yml) runs formatting checks, unit tests, SQLDelight migration verification, and an Android release build. A successful CI run does not replace testing on a physical Android device.

## 📜 Open-source licensing

KuroToon is an independent Android application. This repository includes code and third-party components distributed under open-source licenses. Required copyright notices, license texts, and attribution must remain available in the repository to comply with those licenses; see [LICENSE](./LICENSE). Third-party components may have separate terms. KuroToon has its own product identity and is not presented as another project's official app.

## 🤝 Contributing

Please review [CODE_OF_CONDUCT.md](./CODE_OF_CONDUCT.md) and [CONTRIBUTING.md](./CONTRIBUTING.md). Roadmap items should only be marked complete after implementation and verification.

---

<p align="center">
  <strong>KuroToon — every season, every story. Always with Kuru. 💜</strong><br/>
  <sub>Find your next world. Keep your reading yours.</sub>
</p>
