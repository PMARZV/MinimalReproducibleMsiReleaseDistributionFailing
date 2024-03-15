import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation("media.kamel:kamel-image-default:1.0.0-beta.5")
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Exe, TargetFormat.Deb)
            packageName = "test.cmp.gd"
            packageVersion = "1.0.0"
            description = "Compose Example App"
            copyright = "© 2024 My Name. All rights reserved."
        }

        buildTypes.release.proguard {
          //  configurationFiles.from(project.file("compose-desktop.pro"))
            obfuscate.set(true)


        }

    }
}
