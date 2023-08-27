plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}
apply(rootDir.path + "/dependencies.gradle")

android {
    namespace = "com.mohammad.delloittetask.features.news.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    flavorDimensions += "version"
    productFlavors {
        create("development") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://api.nytimes.com/svc/\"")
        }

        create("production") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://api.nytimes.com/svc/\"")
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
        debug {
            isMinifyEnabled = false
            isJniDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:component"))
    implementation(project(":core:storage"))
    implementation(project(":features:news:data"))
    implementation(project(":features:news:domain"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}