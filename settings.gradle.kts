pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

}

rootProject.name = "DelloitteTask"
include(":app")
include(":features:splash:presentation")
include(":core:navigation")
include(":core:network")
include(":core:storage")
include(":features:main:presentation")
include(":features:splash:domain")
include(":core:component")

include(":features:auth:presentation")
include(":features:auth:domain")
