rootProject.name = "operator-plugin"
include(
        "operator-plugin-core",
        "permissions-system")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.0")
}

