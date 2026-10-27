# Evidence from DEX class tables: Pou 1.4.139

This note records a second static pass over the supplied APK. It does not contain decompiled method bodies or a modified game.

## Class inheritance and method declarations

The DEX class table identifies:

- `me.pou.app.App` extends `android.app.Activity`; it declares lifecycle methods including `onCreate`, `onPause`, and `onResume`.
- `me.pou.app.view.AppView` extends `android.view.SurfaceView`; it declares `onTouchEvent`, gesture callbacks (`onDown`, `onFling`, `onLongPress`, `onScroll`, `onSingleTapUp`), `onCreateInputConnection`, and surface lifecycle callbacks (`surfaceCreated`, `surfaceChanged`, `surfaceDestroyed`).
- The DEX string table includes Android accessibility API names such as `AccessibilityNodeProvider`, `AccessibilityNodeInfo`, and `View.AccessibilityDelegate`. These names may originate from Android libraries and do not, on their own, prove that the game exposes its own virtual accessibility nodes.

## Practical conclusion

The main view handles touch gestures through a custom `SurfaceView`, so the next step for a true accessibility modification is to establish the mapping between visual controls and game actions. The class table does not reveal the game’s internal scene graph or hit-test mapping. The original source and R8 mapping file were not supplied, so method names and internal structure remain partly obfuscated.

No change has been applied to the original Pou APK. This is static class-table analysis, not a completed accessibility patch or a runtime TalkBack audit.
