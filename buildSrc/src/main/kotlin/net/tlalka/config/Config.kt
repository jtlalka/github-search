package net.tlalka.config

/**
 * Gradle project configuration.
 */
object Config {

    // Build plugins
    const val androidToolsVersion = "3.5.1"
    const val kotlinVersion = "1.4.0"
    const val detektVersion = "1.0.0.RC9.2"
    const val dexcountVersion = "0.8.6"
    const val dokkaVersion = "0.10.0"

    // Compile versions
    const val androidCoreVersion = "1.1.0"
    const val androidAppCompatVersion = "1.1.0"
    const val constraintLayoutVersion = "2.0.0"
    const val dynamicAnimationVersion = "1.1.0-alpha03"
    const val androidLifecycleVersion = "2.2.0"
    const val androidNavigationVersion = "2.2.0"
    const val androidMaterialVersion = "1.1.0"
    const val kotlinCoroutinesVersion = "1.4.1"
    const val retrofitVersion = "2.6.0"
    const val okHttpVersion = "3.11.0"

    // Test versions
    const val junitVersion = "4.12"
    const val junitExtVersion = "1.1.1"
    const val mockitoVersion = "2.2.0"
    const val androidTestingVersion = "2.1.0"
    const val espressoVersion = "3.2.0"

    object Android {
        const val minSdkVersion = 21
        const val targetSdkVersion = 30
        const val compileSdkVersion = 30
    }

    object Build {
        const val androidPlugin = "com.android.tools.build:gradle:$androidToolsVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val detektPlugin = "gradle.plugin.io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$detektVersion"
        const val dexcountPlugin = "com.getkeepsafe.dexcount:dexcount-gradle-plugin:$dexcountVersion"
        const val dokkaPlugin = "org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion"
    }

    object Libs {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVersion"
        const val androidCoreKtx = "androidx.core:core-ktx:$androidCoreVersion"
        const val androidAppCompat = "androidx.appcompat:appcompat:$androidAppCompatVersion"
        const val androidConstraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val androidDynamicAnimation = "androidx.dynamicanimation:dynamicanimation:$dynamicAnimationVersion"
        const val androidLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:$androidLifecycleVersion"
        const val androidLifecycleExtension = "androidx.lifecycle:lifecycle-extensions:$androidLifecycleVersion"
        const val androidNavigationFragment = "androidx.navigation:navigation-fragment-ktx:$androidNavigationVersion"
        const val androidMaterialDesign = "com.google.android.material:material:$androidMaterialVersion"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"

        const val junit = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoVersion"
        const val androidTesting = "androidx.arch.core:core-testing:$androidTestingVersion"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
    }
}
