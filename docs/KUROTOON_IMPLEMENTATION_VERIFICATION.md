# KuroToon Implementation Verification System

**Purpose:** Make sure each change implements the agreed KuroToon product—not merely documents it—and that earlier requirements are rechecked as the app evolves.

**Source of truth:** `docs/KUROTOON_UI_FOUNDATION.md` plus this verification register and the approved KuroToon brand references. When requirements conflict, record the conflict and resolve it explicitly; do not silently drop an earlier requirement.

## Rules for every implementation change

1. **Trace the requirement.** Identify the exact requirement(s) being implemented and the existing screen, data model, navigation route, or service affected.
2. **Inspect before changing.** Follow current app architecture, source/provider behavior, persistence, back navigation, deep links, and existing tests. Do not replace functioning infrastructure just to make a visual change.
3. **Implement, don't just describe.** A roadmap, mockup, empty component, or documentation entry is not counted as a delivered feature.
4. **Keep previous requirements in scope.** Before marking a feature complete, run the relevant regression checks from this register. A new screen must not break earlier tabs, reader flows, source management, saved state, or accessibility.
5. **Be honest about status.** Use only these states:
   - **Not started** — no implementation evidence.
   - **In progress** — partial implementation or missing validation.
   - **Implemented, unverified** — code exists but relevant checks have not passed.
   - **Verified** — implementation evidence and applicable checks are recorded.
   - **Blocked** — dependency or failure is documented with a next action.
6. **Never infer verification.** A merged PR is not proof of a successful build; a successful build is not proof of correct behavior on a device. Record CI, tests, manual device checks, and limitations separately.
7. **No fake functionality.** Mock data is permitted only in clearly identified previews/tests. Product screens must not present fabricated manga, reading progress, source health, stats, recommendations, purchases, achievements, or model availability as real.
8. **Protect user data and existing behavior.** Avoid destructive migrations. Preserve library entries, history, reader progress, settings, and repository configuration. Include migration/rollback behavior where relevant.
9. **Use small reviewable PRs.** Each PR should have a narrow purpose, a build/test plan, screenshots for visual changes when available, and a regression note.
10. **Close the loop.** After merge, check the actual workflow result and artifacts; update this register only when the evidence supports the new status.

## Product requirement register

This is a verification checklist, not a claim that all listed features already exist. Update each item with a PR/commit, test or CI run, and verification notes as work progresses.

| ID | Requirement | Minimum evidence before marking Verified | Status |
|---|---|---|---|
| KT-01 | KuroToon identity and approved brand assets | Correct supplied assets used; no invented replacement mascot; screenshots reviewed | In progress |
| KT-02 | Five primary destinations in order: Home, Browse, Shop, Library, Me | Navigation, selection, back behavior, saved state and relevant tests checked | In progress |
| KT-03 | Dark cosmic theme with restrained crimson/rose and violet accents | Theme tokens and contrast reviewed; screens checked in supported themes | In progress |
| KT-04 | Home: continue reading, recent activity, real featured/trending data when available, honest first-run state | Bound to actual persisted library/history/provider data; loading/empty/error/offline states checked | In progress |
| KT-05 | Browse: source-aware search, filters, language/genre/source provenance | Searches across enabled sources; failures, duplicate titles and source labels checked | Not started |
| KT-06 | Shop: free-first cosmetics and personalization | No fake prices/scarcity/checkout; selection persists and actually changes supported appearance | Not started |
| KT-07 | Library: all/unread/updates/favourites, categories, sorting, filters and progress | Existing library data and actions retained; filters, empty states and persistence tested | In progress |
| KT-08 | Me: profile, truthful stats, achievements, preferences and settings | Stats derive from real data; settings persist and can be restored | Not started |
| KT-09 | Repositories under Me → Settings → Sources → Repositories | Add/edit/remove/enable/disable/sync flows tested; no extra bottom tab; source state persists | Not started |
| KT-10 | Existing MangaDex/native provider remains independent and disableable | Search/read behavior checked with provider enabled and disabled | Not started |
| KT-11 | Repository ingestion without executing third-party code | Repository metadata parsed as data; untrusted code is never run during ingestion; hostile input tests | Not started |
| KT-12 | Extension validation, install lifecycle and compatibility states | Validate/download/install/enable/disable/update/remove/failure paths and recovery tested | Not started |
| KT-13 | Isolated extension runtime and structured source capabilities | Extension cannot access app DOM/state, auth/session, arbitrary storage or unrestricted native APIs; permission boundaries tested | Not started |
| KT-14 | Cross-source identity normalization and deduplication | Same series can be linked without erasing source provenance; chapter variants/languages handled | Not started |
| KT-15 | Reader core and settings | Page/continuous modes, direction, fit/zoom, gestures, progress persistence and recovery checked | Not started |
| KT-16 | Reader Studio opened from reader controls/settings | Settings entry works; no new primary navigation tab; preferences persist | Not started |
| KT-17 | Atmospheric Engine | Mixer, ambience/music controls, presets, per-series preferences, ducking and legal audio provenance checked | Not started |
| KT-18 | Voice Dubbing Engine | OCR/dialogue/voice settings, languages, pronunciation, caching, provider/model management and failure handling checked | Not started |
| KT-19 | Kuro Flow orchestration | Page analysis → dialogue order → voice assignment → speech/audio → controlled scroll/page advance; pause/retry/manual correction tested | Not started |
| KT-20 | Reader modes and varied reading layouts | Bubble/panel/continuous/dubbing-only/scroll-only/manual modes; RTL, vertical text and webtoon layouts checked | Not started |
| KT-21 | AI/model downloads, storage, compatibility and privacy | Licensing/provenance shown; download/delete/storage budget and on-device/remote disclosure checked | Not started |
| KT-22 | Accessibility, low-end performance, battery and reduced motion | AI off has no AI overhead; touch targets, contrast, motion, memory and recovery reviewed on representative devices | Not started |
| KT-23 | Android build and APK delivery | Current main commit builds; APK artifact exists and can be downloaded; install/launch smoke test recorded separately | In progress |
| KT-24 | Upstream attribution and legal notices | Required license/copyright/attribution retained; no misleading product claims or prototype-as-product links | In progress |
| KT-25 | Regression of earlier requirements after each merge | Relevant prior checklist items re-run; failures fixed or explicitly blocked | In progress |

## Required PR verification record

Copy this into each KuroToon implementation PR and complete it before merge:

- [ ] Requirement IDs addressed: `KT-__`
- [ ] Previous requirements/regressions reviewed: `KT-__`
- [ ] Existing architecture and affected flows traced before editing
- [ ] Implementation is wired to real app data/services, or any mock is clearly limited to preview/test
- [ ] Build/CI result linked (do not write “passed” until the result is green)
- [ ] Relevant unit/integration/UI tests run, or explain why unavailable
- [ ] Loading, empty, error, offline and recovery states considered where applicable
- [ ] Persistence, navigation/back behavior, deep links and migration impact checked where applicable
- [ ] Accessibility, theme/contrast, performance and lower-end device impact considered
- [ ] Screenshots/video attached for visual changes when available
- [ ] Manual device install/launch/flow test recorded separately from CI
- [ ] Remaining gaps and blocked requirements listed honestly
- [ ] After merge: workflow and artifact checked; register updated from evidence

## Release gate

Do not call a build “verified” or “ready” until all applicable gates pass:

1. **Source gate:** PR is merged and the tested commit matches the intended commit.
2. **Build gate:** CI completed successfully on that commit.
3. **Artifact gate:** Expected APK artifact exists, is downloadable, and corresponds to that run/commit.
4. **Install gate:** APK installs and launches on an Android device/emulator.
5. **Flow gate:** Smoke test covers launch, primary navigation, library access, opening a series/chapter when a valid source is available, reader progress, and settings persistence.
6. **Regression gate:** Earlier completed requirements still pass relevant checks.
7. **Honesty gate:** Any unchecked feature, known issue, permission requirement, or unavailable test is disclosed.

A cancelled, skipped, pending, or failed workflow does not pass the build gate. An APK generated locally does not prove the GitHub artifact gate. A successful CI build does not by itself pass the install or flow gates.

## Progress update format

When reporting progress, summarize:
- **Verified now:** requirements with linked evidence.
- **Implemented, not verified:** code exists but evidence is missing.
- **Still missing:** requirements with no complete implementation.
- **Blocked:** reason and the next action.
- **Latest build:** commit, workflow result, artifact status, and device-test status.

Never describe the whole product as complete merely because a phase or APK is complete.
