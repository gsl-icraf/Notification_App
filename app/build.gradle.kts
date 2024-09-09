plugins {
    alias(notation = libs.plugins.android.application)
    alias(notation = libs.plugins.jetbrains.kotlin.android)
    alias(notation = libs.plugins.ksp)
    alias(notation = libs.plugins.kotlinx.serialization)
    alias(notation = libs.plugins.safe.args)
    alias(notation = libs.plugins.google.services)
}

android {
    namespace = "cifor.icraf.notificationsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "cifor.icraf.notificationsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles( files = arrayOf(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        buildConfig = true
    }
}

dependencies {

    implementation(dependencyNotation = libs.androidx.core.ktx)
    implementation(dependencyNotation = libs.androidx.appcompat)
    implementation(dependencyNotation = libs.material)

    implementation(dependencyNotation = libs.bundles.networking)
    implementation(dependencyNotation = libs.bundles.koin)
    implementation(dependencyNotation = libs.room.ktx)
    implementation(dependencyNotation = libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(dependencyNotation = libs.splash.screen)
    implementation(dependencyNotation = libs.timber)
    implementation(dependencyNotation = libs.bundles.navigation)

    implementation(dependencyNotation = platform(libs.firebase.bom))
    implementation(dependencyNotation = libs.firebase.cloud.messaging)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(dependencyNotation = libs.kotlin.coroutines.test)
    testImplementation(dependencyNotation = libs.mockk)
    androidTestImplementation(dependencyNotation = libs.kotlin.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(dependencyNotation = libs.fragment.testing)
    debugImplementation(dependencyNotation = libs.fragment.testing.manifest)
    androidTestImplementation(dependencyNotation = libs.androidx.test.runner)
    androidTestImplementation(dependencyNotation = libs.androidx.test.rules)

    debugImplementation(dependencyNotation = libs.leak.canary)

}