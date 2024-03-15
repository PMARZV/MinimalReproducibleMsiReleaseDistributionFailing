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

            //TRY ONE TIME WITH MATERIAL 3 ENABLED AND THEN DISABLE IT
           implementation(compose.material3)


            implementation(compose.ui)
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
            targetFormats(TargetFormat.Msi, TargetFormat.Exe)
        }

        buildTypes.release.proguard {
            obfuscate.set(true)
            //Setting this to false or optimize.set(false) doesn't change the result

        }


    }
}
