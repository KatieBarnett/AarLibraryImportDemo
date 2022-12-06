# AarLibraryImportDemo
Demo of Jetpack Compose Preview not rendering issue when using an aar library for resources

## Process

View previews using split view in `DesignSystemComponents.kt` file. They will not render.

Library is included as `implementation files("../libs/theme-release.aar")`
This was created from `SomeAarLibrary` project. 

### Image

![Demo](demo.png "Demo")

## Observed in

### Android Studio Dolphin

Android Studio Dolphin | 2021.3.1 Patch 1
Build #AI-213.7172.25.2113.9123335, built on September 30, 2022
Runtime version: 11.0.13+0-b1751.21-8125866 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 12.0.1
GC: G1 Young Generation, G1 Old Generation
Memory: 4096M
Cores: 10
Registry:
external.system.auto.import.disabled=true
ide.text.editor.with.preview.show.floating.toolbar=false

Non-Bundled Plugins:
idea.plugin.protoeditor (213.6461.28)
detekt (1.21.3-android)
com.vermouthx.idea (1.13.3)
org.intellij.plugins.markdown (213.6777.22)
gherkin (213.6461.19)
com.intellij.lang.jsgraphql (3.3.0)
com.draculatheme.idea (1.3.3)
cucumber-java (213.5744.125)
Dart (213.7433)
net.lagerwey.cucumber-kotlin (2021.3.0)
kotest-plugin-intellij (1.2.63-IC-2021.3)
io.flutter (71.0.3)

### Android Studio Flamingo

Android Studio Flamingo | 2022.2.1 Canary 9
Build #AI-222.4345.14.2221.9321504, built on November 23, 2022
Runtime version: 17.0.4.1+0-17.0.4.1b469.62-9127311 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 12.0.1
GC: G1 Young Generation, G1 Old Generation
Memory: 4096M
Cores: 10
Metal Rendering is ON
Registry:
external.system.auto.import.disabled=true
debugger.watches.in.variables=false
ide.text.editor.with.preview.show.floating.toolbar=false
ide.instant.shutdown=false
gradle.version.catalogs.dynamic.support=true

Non-Bundled Plugins:
idea.plugin.protoeditor (222.4345.14)
detekt (1.22.0)
kotest-plugin-intellij (1.2.63-IC-2022.2)

## Stacktrace
java.lang.ClassNotFoundException: dev.katiebarnett.someaarlibrary.theme.MyCoolTheme
at com.android.tools.idea.rendering.classloading.loaders.DelegatingClassLoader.findClass(DelegatingClassLoader.kt:81)
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:589)
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
at com.android.tools.idea.rendering.classloading.loaders.DelegatingClassLoader.loadClass(DelegatingClassLoader.kt:65)
at dev.katiebarnett.aarlibraryimportdemo.designsystem.DesignSystemComponentsKt.buttonColors(DesignSystemComponents.kt:17)
at dev.katiebarnett.aarlibraryimportdemo.designsystem.DesignSystemComponentsKt.ThemedButton(DesignSystemComponents.kt:33)
at dev.katiebarnett.aarlibraryimportdemo.designsystem.ComposableSingletons$DesignSystemComponentsKt$lambda-2$1.invoke(DesignSystemComponents.kt:52)
at dev.katiebarnett.aarlibraryimportdemo.designsystem.ComposableSingletons$DesignSystemComponentsKt$lambda-2$1.invoke(DesignSystemComponents.kt:51)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.material3.TextKt.ProvideTextStyle(Text.kt:261)
at androidx.compose.material3.MaterialThemeKt$MaterialTheme$1.invoke(MaterialTheme.kt:81)
at androidx.compose.material3.MaterialThemeKt$MaterialTheme$1.invoke(MaterialTheme.kt:80)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.material3.MaterialThemeKt.MaterialTheme(MaterialTheme.kt:73)
at dev.katiebarnett.aarlibraryimportdemo.designsystem.DesignSystemComponentsKt.ThemedButtonPreview(DesignSystemComponents.kt:51)
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.base/java.lang.reflect.Method.invoke(Method.java:566)
at androidx.compose.ui.tooling.ComposableInvoker.invokeComposableMethod(ComposableInvoker.kt:155)
at androidx.compose.ui.tooling.ComposableInvoker.invokeComposable(ComposableInvoker.kt:195)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$composable$1.invoke(ComposeViewAdapter.kt:711)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1$composable$1.invoke(ComposeViewAdapter.kt:709)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1.invoke(ComposeViewAdapter.kt:746)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3$1.invoke(ComposeViewAdapter.kt:704)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.ui.tooling.InspectableKt.Inspectable(Inspectable.kt:61)
at androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1.invoke(ComposeViewAdapter.kt:651)
at androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1.invoke(ComposeViewAdapter.kt:650)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview(ComposeViewAdapter.kt:645)
at androidx.compose.ui.tooling.ComposeViewAdapter.access$WrapPreview(ComposeViewAdapter.kt:135)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3.invoke(ComposeViewAdapter.kt:704)
at androidx.compose.ui.tooling.ComposeViewAdapter$init$3.invoke(ComposeViewAdapter.kt:701)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.ui.platform.ComposeView.Content(ComposeView.android.kt:404)
at androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1.invoke(ComposeView.android.kt:250)
at androidx.compose.ui.platform.AbstractComposeView$ensureCompositionCreated$1.invoke(ComposeView.android.kt:249)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.ui.platform.CompositionLocalsKt.ProvideCommonCompositionLocals(CompositionLocals.kt:177)
at androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3.invoke(AndroidCompositionLocals.android.kt:123)
at androidx.compose.ui.platform.AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3.invoke(AndroidCompositionLocals.android.kt:122)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(AndroidCompositionLocals.android.kt:114)
at androidx.compose.ui.platform.WrappedComposition$setContent$1$1$3.invoke(Wrapper.android.kt:157)
at androidx.compose.ui.platform.WrappedComposition$setContent$1$1$3.invoke(Wrapper.android.kt:156)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider(CompositionLocal.kt:228)
at androidx.compose.ui.platform.WrappedComposition$setContent$1$1.invoke(Wrapper.android.kt:156)
at androidx.compose.ui.platform.WrappedComposition$setContent$1$1.invoke(Wrapper.android.kt:140)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:107)
at androidx.compose.runtime.internal.ComposableLambdaImpl.invoke(ComposableLambda.jvm.kt:34)
at androidx.compose.runtime.ActualJvm_jvmKt.invokeComposable(ActualJvm.jvm.kt:78)
at androidx.compose.runtime.ComposerImpl$doCompose$2$5.invoke(Composer.kt:3248)
at androidx.compose.runtime.ComposerImpl$doCompose$2$5.invoke(Composer.kt:3238)
at androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(DerivedState.kt:341)
at androidx.compose.runtime.SnapshotStateKt.observeDerivedStateRecalculations(Unknown Source)
at androidx.compose.runtime.ComposerImpl.doCompose(Composer.kt:3238)
at androidx.compose.runtime.ComposerImpl.composeContent$runtime_release(Composer.kt:3173)
at androidx.compose.runtime.CompositionImpl.composeContent(Composition.kt:587)
at androidx.compose.runtime.Recomposer.composeInitial$runtime_release(Recomposer.kt:950)
at androidx.compose.runtime.CompositionImpl.setContent(Composition.kt:519)
at androidx.compose.ui.platform.WrappedComposition$setContent$1.invoke(Wrapper.android.kt:140)
at androidx.compose.ui.platform.WrappedComposition$setContent$1.invoke(Wrapper.android.kt:131)
at androidx.compose.ui.platform.AndroidComposeView.setOnViewTreeOwnersAvailable(AndroidComposeView.android.kt:1060)
at androidx.compose.ui.platform.WrappedComposition.setContent(Wrapper.android.kt:131)
at androidx.compose.ui.platform.WrappedComposition.onStateChanged(Wrapper.android.kt:182)
at androidx.lifecycle.LifecycleRegistry$ObserverWithState.dispatchEvent(LifecycleRegistry.java:360)
at androidx.lifecycle.LifecycleRegistry.addObserver(LifecycleRegistry.java:202)
at androidx.compose.ui.platform.WrappedComposition$setContent$1.invoke(Wrapper.android.kt:138)
at androidx.compose.ui.platform.WrappedComposition$setContent$1.invoke(Wrapper.android.kt:131)
at androidx.compose.ui.platform.AndroidComposeView.onAttachedToWindow(AndroidComposeView.android.kt:1147)
at android.view.View.dispatchAttachedToWindow(View.java:20753)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3490)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3497)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3497)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3497)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3497)
at android.view.ViewGroup.dispatchAttachedToWindow(ViewGroup.java:3497)
at android.view.AttachInfo_Accessor.setAttachInfo(AttachInfo_Accessor.java:58)
at com.android.layoutlib.bridge.impl.RenderSessionImpl.inflate(RenderSessionImpl.java:366)
at com.android.layoutlib.bridge.Bridge.createSession(Bridge.java:436)
at com.android.tools.idea.layoutlib.LayoutLibrary.createSession(LayoutLibrary.java:121)
at com.android.tools.idea.rendering.RenderTask.createRenderSession(RenderTask.java:717)
at com.android.tools.idea.rendering.RenderTask.lambda$inflate$9(RenderTask.java:873)
at com.android.tools.idea.rendering.RenderExecutor$runAsyncActionWithTimeout$3.run(RenderExecutor.kt:192)
at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
at java.base/java.lang.Thread.run(Thread.java:829)



