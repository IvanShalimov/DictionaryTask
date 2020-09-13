import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "ru.ivan.englishdictionary"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val moxyVersion = "2.1.2"
val daggerVersion = "2.29.1"
val glideVersion = "4.11.0"
val rxBinding = "4.0.0"

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    testImplementation("junit:junit:4.13")

    //GSON
    implementation("com.google.code.gson:gson:2.8.6")
    //Dagger2
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    //Moxy
    //implementation "com.github.moxy-community:moxy-androidx:$moxyVersion"
    implementation("com.github.moxy-community:moxy-androidx:$moxyVersion")
    implementation("com.github.moxy-community:moxy-ktx:$moxyVersion")
    kapt("com.github.moxy-community:moxy-compiler:$moxyVersion")
    //Glide
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.8.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.8.1")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    //implementation ("com.squareup.okhttp3:logging-interceptor:3.8.0")
    //rx-java
    implementation("io.reactivex.rxjava3:rxjava:3.0.6")
    //rx-binding
    implementation("com.jakewharton.rxbinding4:rxbinding:$rxBinding")
    implementation("com.jakewharton.rxbinding4:rxbinding-core:$rxBinding")
    implementation("com.jakewharton.rxbinding4:rxbinding-appcompat:$rxBinding")
}
