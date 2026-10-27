# Runtime architecture clues from DEX strings

A second static pass over the supplied APK found these application-owned class descriptors:

- `me/pou/app/App`
- `me/pou/app/view/AppView`
- `me/pou/app/NotificationsService`
- `me/pou/app/GenericFileProvider`

The app class names are present in the DEX files, and the manifest points to `me.pou.app.App` as the launcher activity. This indicates the package contains app-specific Java/Kotlin bytecode, but it does not give us the original source files.

The APK does not expose a source project, Gradle configuration, original Kotlin/Java files, or a reproducible build recipe. A class name such as `AppView` alone is not enough to determine which controls are custom-drawn or to safely patch accessibility behavior. The next technically responsible step is to inspect the class methods and runtime view hierarchy with a decompiler and on-device testing, then validate any change against the original game.

## Why the independent Kotlin sample is not a replacement

The separate Hamdel Pet sample is a new native app with a small set of pet-care interactions. It is not built from Pou's source and cannot preserve all of Pou's game systems merely by copying assets. Do not describe the sample as an accessible Pou release.

## Recommended route to a true accessibility patch

- If the rights holder can provide source code or a supported SDK, modify the actual app and add accessibility semantics to the real controls.
- If only the APK is available, first complete a documented static/runtime analysis and confirm that reverse engineering and redistribution are covered by the authorization. Keep any experiment in a separate branch and APK.
- Test focus order, labels, action names, state changes, gestures, and original sound playback with TalkBack enabled.
- Preserve the original app as an untouched reference and compare each tested screen after modifications.

This report does not claim the original app has been patched or that TalkBack compatibility has been verified.
