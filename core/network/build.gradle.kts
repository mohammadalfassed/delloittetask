plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}
apply(rootDir.path + "/dependencies.gradle")

android {
    namespace = "com.mohammad.delloittetask.network"
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
            buildConfigField("String", "BASE_URL", "\"https://api.test.example.com/\"")
        }

        create("production") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://api.test.example.com/\"")
        }
    }

    buildTypes.all {
        buildConfigField("String", "BASE_URL", "\"https://api.test.example.com/\"")

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
    implementation(project(":core:storage"))
    implementation(project(":core:navigation"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}