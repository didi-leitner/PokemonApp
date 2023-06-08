@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
    alias(libs.plugins.kotlin.serialize) ////needed for BindingAdapter for Glide, and Hilt

    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")

}




android {
    compileSdk = (33)

    defaultConfig {
        applicationId = "com.didi.pokemon"
        minSdk = (24)
        targetSdk = (33)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //javaCompileOptions {
        //    annotationProcessorOptions {
        //        arguments["dagger.hilt.disableModulesHaveInstallInCheck"] = "true"
        //    }
        //}
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            //proguardFiles getDefaultProguardFile ('proguard-android-optimize.txt'), 'proguard-rules.pro'
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
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    namespace = "com.didi.pokemon.app"

}

dependencies {

    //kotlin
    implementation(libs.jetbrains.kotlin.stdlib)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)


    //androidx core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.window)


    //material
    implementation(
        libs.google.android.material
    )
    //implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.materialWindow)
    implementation(libs.androidx.compose.material.iconsExtended)
    implementation(libs.androidx.material3)


    //COMPOSE
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.coil.kt.compose)


    //--intrrop
    implementation(libs.androidx.ui.viewbinding)


    //Accompanist - permissions
    implementation(libs.accompanist.adaptive)
    implementation(libs.accompanist.permissions)

    //----------------Navigation--------------------------
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui.ktx)
    // Feature module Support
    //implementation "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"
    // Testing Navigation
    //androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
    // Jetpack Compose Integration
    //implementation "androidx.navigation:navigation-compose:1.0.0-alpha03"


    //----------------ROOM------------------------
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    //--------------Retrofit--------------------------
    implementation(libs.retrofit)
    implementation(libs.converter.gson)


    //----------------Hilt--------------------------
    compileOnly(libs.assisted.inject.annotations.dagger2)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler) //KSP will crash


    //----------------CameraX--------------------------
    // CameraX core library using camera2 implementation
    implementation(libs.androidx.camera.camera2)
    // CameraX Lifecycle Library
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.core)

    // CameraX View class
    implementation(libs.androidx.camera.view)


    //-----------------Paging3---------------------------------
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.room.paging)

    //------------------Serialize JSON----------------------
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.gson)
    implementation(libs.moshi.kotlin)
    implementation(libs.converter.moshi)


    //-------------------Glide----------
    ksp(libs.glide.compiler)
    implementation(libs.glide)


    //-------------------MLKit--------------
    //implementation 'com.google.mlkit:image-labeling:17.0.2'
    implementation(libs.objectDetection)
    //implementation 'com.google.mlkit:face-detection:16.0.3'
    implementation(libs.text.recognition)


    api(libs.guava)


    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.androidx.core.testing)


}