plugins {
    kotl/.`in("jvm") version "1.3.60"
    kotlin("kapt") version "1.3.60"
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
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

        testImplementation("io.mockk:mockk:1.9.3")
        testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    }
}
