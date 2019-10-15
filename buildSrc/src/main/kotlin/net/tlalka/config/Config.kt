package net.tlalka.config

/**
 * Gradle project configuration.
 */
object Config {

    // Build
    const val androidToolsVersion = "3.5.1"
    const val kotlinVersion = "1.3.50"

    // Libs
    const val androidCoreVersion = "1.1.0"
    const val androidAppCompatVersion = "1.1.0"
    const val androidLifecycleVersion = "2.1.0"
    const val constraintLayoutVersion = "1.1.3"
    const val dynamicAnimationVersion = "1.1.0-alpha01"
    const val junitVersion = "4.12"
    const val junitExtVersion = "1.1.1"
    const val espressoVersion = "3.2.0"

    object Android {
        const val minSdkVersion = 21
        const val targetSdkVersion = 28
        const val compileSdkVersion = 28
    }

    object Build {
        const val androidPlugin = "com.android.tools.build:gradle:$androidToolsVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    }

    object Libs {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

        const val androidCoreKtx = "androidx.core:core-ktx:$androidCoreVersion"
        const val androidAppCompat = "androidx.appcompat:appcompat:$androidAppCompatVersion"
        const val androidLifecycle = "androidx.lifecycle:lifecycle-extensions:$androidLifecycleVersion"
        const val androidLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$androidLifecycleVersion"

        const val androidConstraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val androidDynamicAnimation = "androidx.dynamicanimation:dynamicanimation:$dynamicAnimationVersion"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
    }
}
