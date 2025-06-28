plugins {
    kotlin("jvm") version "2.1.21"
    id("fabric-loom") version "1.10-SNAPSHOT"
}

group = "dev.darwincereska"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.4")
    mappings("net.fabricmc:yarn:1.21.4+build.8:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.14")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.119.3+1.21.4")
    implementation(kotlin("stdlib"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

loom {
    runs {
        create("runServer") {
            server()
            name = "Minecraft Server"
        }
    }
}
