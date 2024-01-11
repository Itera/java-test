plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.allopen)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.deps)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)
    jacoco
}

group = "com.itera"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.h2)
    implementation(libs.flyway)
    implementation(libs.kotlinx)

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.mockk)
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            freeCompilerArgs = listOf("-Xcontext-receivers")
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
    }
}


tasks.named("check") {
    dependsOn(tasks.jacocoTestReport)
}

