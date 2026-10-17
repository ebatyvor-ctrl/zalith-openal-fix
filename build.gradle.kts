plugins {
    id("java")
}

group = "me.ebatyvor"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/") { name = "FabricMC" }
}

dependencies {
    compileOnly("net.fabricmc:sponge-mixin:0.17.3+mixin.0.8.7")
    compileOnly("org.lwjgl:lwjgl:3.4.1")
    compileOnly("org.lwjgl:lwjgl-openal:3.4.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
}

tasks.jar {
    manifest {
        attributes(
            "Fabric-Loom-Remap" to "false",
            "Implementation-Title" to "Zalith OpenAL Fix",
            "Implementation-Version" to project.version
        )
    }
}
