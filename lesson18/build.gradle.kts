import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    flatDir { dirs("../libs") }
}

dependencies {
    implementation("pt.isel:CanvasLib-jvm:1.0.0")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}