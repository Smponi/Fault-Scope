@file:Suppress("ConvertLambdaToReference")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.21"
	id("org.jetbrains.intellij") version "1.12.0"
}

group = "com.smponi.intellij.faultscope"
version = "1.1.2"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

intellij {
	version.set("2022.1")
	updateSinceUntilBuild.set(false)
}

tasks.patchPluginXml {
	sinceBuild.set("221")
}

tasks.buildSearchableOptions {
	enabled = false
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "11"
	kotlinOptions.freeCompilerArgs = listOf(
		"-Xjvm-default=enable"
	)
}
