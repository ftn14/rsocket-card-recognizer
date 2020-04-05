group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    OCR start
    implementation("net.sourceforge.tess4j:tess4j:4.5.1")
    implementation("net.java.dev.jna:jna:5.2.0")
    implementation("net.java.dev.jna:jna-platform:5.2.0")
//    OCR end
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}