plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.drmiaji.fortyahadith"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.drmiaji.fortyahadith"
        minSdk = 24
        targetSdk = 35
        versionCode = 12
        versionName = "2.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {
    // Kotlin
    implementation(libs.kotlin.stdlib)

    // AndroidX Core and AppCompat
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // RecyclerView
    implementation(libs.androidx.recyclerview)

    // Lifecycle: ViewModel, LiveData, Runtime
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation (Compose)
    implementation(libs.androidx.navigation.compose.jvmstubs)

    // Material Design           // Material 3 Compose support
    implementation(libs.material3)                      // Possibly same as above, verify usage
    implementation(libs.material)                       // Material Design 2 library (Views)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)

    // Preferences
    implementation(libs.androidx.preference.ktx)

    // Async Layout Inflater (optional)
    implementation(libs.androidx.asynclayoutinflater)

    // Firebase Crashlytics (build tools)
    implementation(libs.firebase.crashlytics.buildtools)

    // JSON Parsing
    implementation(libs.gson)
}