# KuroToon Interaction and Personalization Direction

**Status:** Product implementation brief  
**Last updated:** October 15, 2026.

## Product ambition

KuroToon should feel like a small cosmic world built around reading—not a generic manga catalog with a dark theme. The user's existing Lovable prototype and supplied screenshots are the visual source of truth. Do not replace its brand with invented layouts, mascots, or unrelated art. The blue/cyan Rewards reference belongs to a separate prototype and is not the core KuroToon palette.

## Core visual language

- Near-black surfaces and restrained red/crimson-pink highlights, following the supplied Home and Browse references.
- Rounded cover cards, clear type hierarchy, generous spacing, and readable contrast.
- Purple/cosmic glints and warm gold are supporting accents, not a forced blue theme.
- Keep the five primary destinations: Home, Browse, Rewards, Library, Me.
- Preserve the Kuru mascot only where approved supplied assets are available; never generate a substitute and present it as the official mascot.
- Keep source management and repositories under Me → Settings → Sources → Repositories, not as a new primary navigation destination.

## Liquid particle interaction system

Implement a shared, lightweight interaction layer rather than one-off effects on every screen.

### Default touch response
1. A tap creates a soft expanding water ripple centered on the touch point.
2. A few subtle particles or glints briefly follow the ripple edge, then fade.
3. Selected navigation and important interactive surfaces may retain a restrained crimson-pink glow.
4. Transitions should feel fluid and quick, never delay the action or obscure text and manga art.

### Personal controls
Expose customization in Me → Settings → Appearance / Motion:
- Effects: On / Off.
- Ripple intensity: Subtle / Balanced / Expressive.
- Particle density: Low / Medium / High.
- Animation motion: Reduced / Standard.
- Haptic feedback: On / Off, when supported.
- Optional ambient particles: On / Off.

Use balanced effects by default. Respect Android's system reduced-motion preference where available. Disabling effects must remove decorative animation without removing functionality. Keep animation work bounded, avoid continuously redrawing the entire screen, and ensure touch feedback does not interfere with accessibility or scrolling.

## Me section structure

Make Me the personal control center, not a dumping ground. Suggested hierarchy:

1. **Profile header:** avatar, display name if supported, level/progress only when backed by real data.
2. **Reading at a glance:** truthful statistics based on available local data; hide metrics that cannot be calculated reliably.
3. **Personalization:** appearance, ripple/particles, haptics, reader preferences.
4. **Your KuroToon:** rewards, achievements, cosmetics, and collection—only show progress that is actually persisted.
5. **Sources and repositories:** manage sources, repository status, extension discovery and updates.
6. **Data and safety:** export/import or backup when implemented, storage controls, permissions, privacy information.
7. **App information:** version, release notes, update check, Terms of Service, privacy notice, licenses, and upstream attribution.

Use clear sub-pages for advanced options. Do not crowd every setting into the first Me screen. Avoid fake account sync, fake cloud backup, fabricated reading statistics, or controls that appear interactive but do nothing.

## Free-first product promise

KuroToon is fully free at this stage. No current feature, cosmetic, reward, subscription label, or customization setting is behind a paywall. Do not implement payment, paid tiers, premium currency purchases, or subscription checkout. Any future monetization would be a separately reviewed product decision and would require transparent communication; it is not part of the current build.

## Implementation and acceptance checklist

- [ ] Shared effect component/system; avoid duplicated animation implementations.
- [ ] Effect settings persist across app restarts.
- [ ] Reduced motion and effects-off modes work.
- [ ] Touch feedback does not block input or cause noticeable reader lag.
- [ ] Me sections link to real functionality and do not advertise unfinished features as complete.
- [ ] Terms and privacy information are reachable from app information.
- [ ] Preserve the existing five-destination navigation and upstream license notices.
- [ ] Verify build and device behavior before claiming implementation complete.
