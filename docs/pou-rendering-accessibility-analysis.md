# Rendering and TalkBack investigation

Reference: Pou_v1.4.139.apk (static metadata inspection only).

Confirmed:
- Launcher activity: me.pou.app.App, an Android Activity.
- Main game view: me.pou.app.view.AppView, which extends android.view.SurfaceView.
- AppView has touch and gesture callbacks, including onTouchEvent, onSingleTapUp, onScroll, onFling and onLongPress.
- The APK contains three DEX files; app-specific method names are largely obfuscated.
- The package contains 1,785 images under assets/images/ and 63 audio files identified by filename extension.

Why this matters:
A SurfaceView-based game commonly draws its own controls rather than exposing each control as a native Android Button. TalkBack needs meaningful accessibility nodes, labels, bounds, states and actions that map to the game's existing controls. Merely wrapping the game in a new Kotlin app does not add those semantics to the original view.

Status:
The provided APK has not been modified. No TalkBack runtime test has been completed. This is not a claim that Pou has been made accessible.

Next requirement:
A reproducible source/build project or further verified analysis of the original view and its action mapping is needed before a patch can be safely built and tested. The independent Hamdel Pet sample is not a replacement for Pou.
