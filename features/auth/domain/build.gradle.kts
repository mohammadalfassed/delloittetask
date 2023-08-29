plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
}
apply(rootDir.path + "/sub_project.gradle")
apply(rootDir.path + "/dependencies.gradle")

android {
    namespace = "com.mohammad.delloittetask.features.auth.domain"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:component"))
    implementation(project(":core:storage"))
}