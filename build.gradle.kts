plugins {
    kotlin("jvm") version "1.3.61"
    kotlin("kapt") version "1.3.61"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.60"
}

subprojects {
    apply(plugin = "kotlin")

    version = "0.1"
    group = "bearmug.lambda"

    repositories {
        mavenCentral()
        maven(url = "https://jcenter.bintray.com")
    }

    val kotlinVersion: String by project
    val coroutinesVersion: String by project
    val arrowVersion: String by project
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
        implementation("io.arrow-kt:arrow-core:$arrowVersion")
        implementation("io.arrow-kt:arrow-core-data:$arrowVersion")

        testImplementation("io.mockk:mockk:1.9.3")
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    }
}
