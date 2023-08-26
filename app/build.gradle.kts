plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}
apply(rootDir.path + "/dependencies.gradle")


android {
    namespace = "com.mohammad.delloittetask"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mohammad.delloittetask"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }

    flavorDimensions += "version"
    productFlavors {
        create("development") {
            dimension = "version"
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            buildConfigField("string", "BASE_URL", "\"https://api.test.example.com/\"")
        }

        create("production") {
            dimension = "version"
            buildConfigField("string", "BASE_URL", "\"https://api.test.example.com/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":features:splash:presentation"))
    implementation(project(":features:main:presentation"))
    implementation(project(":features:auth:presentation"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}