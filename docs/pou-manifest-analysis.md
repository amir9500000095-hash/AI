# Manifest and packaging analysis: Pou 1.4.139

This report records metadata read from the supplied APK's binary AndroidManifest.xml. It does not modify the original APK.

## Confirmed manifest values

- Package ID: `me.pou.app`
- Version name: `1.4.139`
- Version code: `288`
- Minimum Android SDK: `24`
- Target SDK: `37`
- Launcher/application activity: `me.pou.app.App`
- Main application label and icon are referenced through Android resources.
- The package contains a bundled font at `assets/fonts/Pou.ttf`.
- The APK contains 2,087 PNG files and 63 audio files (25 MP3, 38 OGG), based on archive entry names.
- The manifest includes the following permissions among others: INTERNET, WAKE_LOCK, WRITE_EXTERNAL_STORAGE, RECORD_AUDIO, ACCESS_NETWORK_STATE, ACCESS_WIFI_STATE, ACCESS_LOCAL_NETWORK, Bluetooth-related permissions, POST_NOTIFICATIONS, READ_BASIC_PHONE_STATE, AD_ID, billing, ads-services, FOREGROUND_SERVICE, and an Amazon privacy-pass permission.
- The manifest declares optional microphone and Bluetooth hardware features.
- Several advertising and billing SDK activities/services are also declared.

## Accessibility implications

The main activity is a compiled application class, not a provided source tree. The manifest alone does not reveal whether the game's screens are native Android Views, custom drawing, or another rendering technique. The archive includes extensive named image resources under `assets/images/` and game strings in `resources.arsc`; this suggests there are useful clues in the package, but it is not sufficient to reconstruct the source project.

A TalkBack audit still requires running the original app on a device or emulator and checking focus order, labels, touch targets, state announcements, and custom-drawn controls. If the main game is rendered through custom canvas or a game engine, making it accessible may require changing the original app code or adding deliberate accessibility-node support; a separate Kotlin sample cannot automatically preserve the original game experience.

## Recommended next technical steps

1. Preserve the original APK as an untouched reference and record its checksum/signing certificate.
2. Inspect the full activity tree and identify the main rendering method and available accessibility nodes at runtime.
3. Build a media catalog by duration and file size. File names are opaque, so do not assign semantic labels until audio is actually identified.
4. Conduct a TalkBack walkthrough on the user's target Android version.
5. Choose a modification path only after confirming the user's authorization scope and whether source code or an official SDK/source package is available.
6. Rebuild and test only in a separate output directory; never overwrite the supplied APK.

## Important limits

- This static analysis does not confirm the developer signing identity or whether Google Play Protect will display a warning.
- This report does not claim that the APK has been made accessible.
- Audio file presence does not prove that all runtime sounds are contained in the APK or that every sound has been identified.
