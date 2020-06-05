group = "com.ftx.h1"
version = Versions.PROJECT

plugins {
    `kotlin-dsl`
    id("org.springframework.boot") version Versions.SPRING_BOOT
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version Versions.KOTLIN
    kotlin("plugin.spring") version Versions.KOTLIN
//    kotlin("kapt") version Versions.KOTLIN
}

//apply<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin>()
//apply<io.spring.gradle.dependencymanagement.DependencyManagementPlugin>()
//apply<KtlintPlugin>()
//apply<org.jetbrains.kotlin.allopen.gradle.SpringGradleSubplugin>()
//apply<org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin>()

repositories {
    mavenCentral()
    //jcenter()
}

dependencies {
    implementation(
        fileTree("libs")
            .filter { it.name.matches(Regex("(.*).jar")) }
    )
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
//    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("io.arrow-kt:arrow-core:0.7.3")
    implementation("io.github.microutils:kotlin-logging:1.7.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}")
    implementation("org.springframework.boot:spring-boot-starter-rsocket")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
//    OCR start
    implementation("net.sourceforge.tess4j:tess4j:4.3.1") // update to last 4.5.1 be unsuccessful
    implementation("net.java.dev.jna:jna:5.2.0")
    implementation("net.java.dev.jna:jna-platform:5.2.0")
//    OCR end
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
//    kapt("org.springframework.boot:spring-boot-configuration-processor:2.2.5.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLIN_COROUTINES}")
    testImplementation("io.projectreactor:reactor-test")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "integration-testing") //TODO: required?
}
