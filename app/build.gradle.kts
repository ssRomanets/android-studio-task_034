plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.task_034"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.task_034"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.room:room-runtime:2.6.1")

    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$rootProject.lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$rootProject.lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-common-java8:$rootProject.lifecycleVersion")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    //implementation("org.jetbrains.kotlin:kotlin-ksp:1.4.0-rc-dev-experimental-20200828")
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk?:1.9.0")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$rootProject.coroutines")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$rootProject.coroutines")
}