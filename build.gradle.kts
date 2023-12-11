plugins {
    kotlin("jvm") version "1.9.0"
}

group = "com.xpepper"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
    testImplementation(platform("io.kotest:kotest-bom:5.8.0"))
    testImplementation("io.kotest", "kotest-assertions-core")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
