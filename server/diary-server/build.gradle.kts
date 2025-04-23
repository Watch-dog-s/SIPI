plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.22"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
// Основные зависимости Spring Boot
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web") // Для REST API
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// База данных (JPA + PostgreSQL)
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql")

	// Валидация
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// Безопасность (опционально)
//	implementation("org.springframework.boot:spring-boot-starter-security")

	// Миграции базы данных (Flyway)
//	implementation("org.flywaydb:flyway-core")

	// Сериализация JSON (Kotlin)
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Логирование
	implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")

	// Тестирование
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-params")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

	// Для тестирования с базой данных
	testImplementation("org.testcontainers:postgresql:1.19.3")
	testImplementation("org.testcontainers:junit-jupiter:1.19.3")

	// Документирование API (Swagger/OpenAPI)
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	// Утилиты (опционально)
	implementation("org.apache.commons:commons-lang3:3.14.0")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
