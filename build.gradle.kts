import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile



plugins {
    java apply true
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.1"
}

group = "org.example"
version = "1.0"


repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinComposeDesktop"
            packageVersion = "1.0.0"
            macOS {
                iconFile.set(project.file("src/main/resources/erythrocytes.ico"))
            }
            windows {
                iconFile.set(project.file("src/main/resources/erythrocytes.ico"))
            }
            linux {
                iconFile.set(project.file("src/main/resources/erythrocytes.ico"))
            }
        }
    }
}