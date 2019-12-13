import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	id("org.flywaydb.flyway") version "6.1.0"

	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
	kotlin("plugin.jpa") version "1.3.50"
}

group = "com.organizationX"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot","spring-boot-starter-data-jpa")
	implementation("org.springframework.boot","spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module","jackson-module-kotlin")
	implementation("org.jetbrains.kotlin", "kotlin-reflect")
	implementation("org.jetbrains.kotlin","kotlin-stdlib-jdk8")
	implementation("io.github.microutils", "kotlin-logging", "1.7.7")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	runtimeOnly("com.h2database:h2")
	compile("org.flywaydb:flyway-core")
	compile("org.springframework.kafka","spring-kafka","2.3.1.RELEASE")
	compile("org.apache.kafka","kafka-clients","2.3.1")
	compile("com.google.code.gson", "gson", "2.8.5")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

flyway {
	url = "jdbc:h2:file:/home/craeder/Workspace/Projects/Estudo/h2DB/dbh2teset"
	user = "sa"
	password = ""
}