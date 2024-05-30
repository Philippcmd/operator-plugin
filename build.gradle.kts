plugins {
    java
}

group = "de.philippCMD"
version "1.0.0"

allprojects {
    apply {
        plugin<JavaPlugin>()
    }

    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/groups/public/")
    }

    dependencies {
        compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    }

    java{
        toolchain{
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }
}