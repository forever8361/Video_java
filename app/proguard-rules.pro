# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Buckupsoftware\Sdk\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable


-keep class android.support.**{*;}
-keep class android.support.v4.** {*;}

-keepclassmembers class com.lezhi.lezvideo.model.** {
    *;
}

-keep class okio.** {*;}
-dontwarn  okio.**
-keep class retrofit2.** {*;}
-dontwarn  retrofit2.**
-keep class rx.** {*;}
-dontwarn  rx.**

# xxx
-keep class com.squareup.** {*;}
-dontwarn  com.squareup.**

# EventBus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

-keep class io.vov.utils.** { *; }
-keep class io.vov.vitamio.** { *; }

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider