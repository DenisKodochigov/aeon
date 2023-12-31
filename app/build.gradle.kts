plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("com.google.devtools.ksp")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.aeon"
    compileSdk = rootProject.extra["targetSdk"] as Int

    defaultConfig {
        applicationId = "com.example.aeon"
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["targetSdk"] as Int
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["composeVersion"] as String
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val composeVersion = rootProject.extra["composeVersion"] as String
    val daggerVersion = rootProject.extra["daggerVersion"] as String
    val roomVersion = "2.6.0"
    val lifecycleVersion = "2.6.2"

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.security:security-crypto:1.0.0")
    //Hilt
    implementation ("com.google.dagger:hilt-android:$daggerVersion")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt ("com.google.dagger:hilt-android-compiler:$daggerVersion")
    //Jetpack  Compose
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    //Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    //Integration with observables
    implementation ("androidx.compose.runtime:runtime:$composeVersion")
    implementation ("androidx.compose.runtime:runtime-rxjava2:$composeVersion")
    //Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation ("androidx.compose.foundation:foundation:$composeVersion")
    implementation ("androidx.compose.foundation:foundation-layout:$composeVersion")
    // Material Design
    implementation("androidx.compose.material3:material3")
    //Implementation ("androidx.compose.material3:material3:1.1.2")
    implementation ("androidx.compose.material:material-icons-core:$composeVersion")
    implementation ("androidx.compose.material:material-icons-extended:$composeVersion")
    //Adaptive
    implementation ("androidx.compose.material3:material3-window-size-class:1.1.2")
    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.7.5")
    //Color Palette
    implementation ("androidx.palette:palette-ktx:1.0.0")
    //LifeCycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    // Room
    implementation ("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.room:room-ktx:$roomVersion")
    implementation ("androidx.room:room-rxjava2:$roomVersion")
    ksp ("androidx.room:room-compiler:$roomVersion")
    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.moshi:moshi:1.15.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.0")
    ksp ("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.9.0")
    //Moshi
    implementation ("com.squareup.moshi:moshi:1.15.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.15.0")
    ksp ("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics")
//Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation ("com.google.dagger:hilt-android-testing:$daggerVersion")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    kaptTest ("com.google.dagger:hilt-android-compiler:$daggerVersion")
}

