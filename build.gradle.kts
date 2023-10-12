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

java {
    sourceCompatibility = JavaVersion.VERSION_20
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
        kotlinOptions {
            freeCompilerArgs = listOf("-Xcontext-receivers")
            jvmTarget = "20"
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
    reports {
        xml.required.set(true)
    }
    dependsOn(tasks.test)
}

configurations.detekt {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            // Detekt needs 1.9.0 to run - this gets around a compatibility issue with spring dependency plugin
            useVersion("1.9.0")
        }
    }
}
