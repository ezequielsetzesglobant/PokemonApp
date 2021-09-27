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
}
