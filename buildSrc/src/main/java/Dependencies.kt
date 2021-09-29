object Versions {

    //Basics
    const val kotlin_stdlib = "1.5.0"
    const val core_ktx = "1.6.0"
    const val appcompat = "1.3.1"

    //UI
    const val material = "1.4.0"
    const val constraintlayout = "2.1.0"

    //Test
    const val junit = "4.13.2"
    const val ext_junit = "1.1.3"
    const val expresso_core = "3.4.0"

    //Koin
    const val koin_version = "2.0.1"

    //Architecture components
    const val lifecycle_version = "2.3.1"

    // Navigation
    const val nav_version = "2.3.5"

    //Coroutines
    const val kotlinx_coroutines_core = "1.5.0"
    const val kotlinx_coroutines_android = "1.5.0"
    const val kotlinx_coroutines_test = "1.3.7"

    //Mockito
    const val mockito_kotlin = "2.2.0"
    const val mockito_core = "2.28.2"
    const val mockito_inline = "2.21.0"

    //Rule
    const val core_testing = "2.1.0"
}

object Dependencies {

    //Basics
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_stdlib}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    //UI
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"

    //Test
    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val expresso_core = "androidx.test.espresso:espresso-core:${Versions.expresso_core}"

    //Koin
    const val koin_test = "io.insert-koin:koin-test:${Versions.koin_version}"
    const val koin_androidx_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"

    //Architecture components
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"

    //Navigation
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    //Coroutines
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines_core}"
    const val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines_android}"
    const val kotlinx_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx_coroutines_test}"

    //Mockito
    const val mockito_kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito_core}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito_inline}"

    //Rule
    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
}
