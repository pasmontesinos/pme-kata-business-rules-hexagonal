plugins {
    kotlin("jvm") version "2.0.20"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.0"
}

group = "mo.staff"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    create("test-acceptance") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val testAcceptanceImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}

configurations["testAcceptanceRuntimeOnly"].extendsFrom(configurations.testRuntimeOnly.get())

val acceptanceTest = task<Test>("acceptanceTest") {
    description = "Runs acceptance tests."
    group = "verification"
    testClassesDirs = sourceSets["test-acceptance"].output.classesDirs
    classpath = sourceSets["test-acceptance"].runtimeClasspath
    useJUnitPlatform()
    shouldRunAfter("test")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.13")
    testImplementation("net.bytebuddy:byte-buddy:1.15.10")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ktlint {
    version.set("0.50.0")
    android.set(false)
    outputToConsole.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
    filter {
        exclude("**/generated/**")
        include("**/*.kt")
    }
}

tasks.check {
    dependsOn("ktlintCheck")
}
