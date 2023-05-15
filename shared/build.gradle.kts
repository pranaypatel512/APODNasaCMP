plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    alias(libs.plugins.buildconfig)
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.8.20"

}

kotlin {
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation(libs.koin.core)

                implementation(libs.ktor.core)
                implementation(libs.ktor.cio)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.json)
                implementation(libs.ktor.logging)

                implementation(libs.kotlinX.serializationJson)

                implementation(libs.multiplatformSettings.noArg)
                implementation(libs.multiplatformSettings.coroutines)

                implementation(libs.napier)

                implementation(libs.kotlinX.dateTime)

                api(libs.decompose)
                api(libs.decompose.compose.jetbrains)
                api(libs.essenty)
                implementation(libs.decompose.router)

            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.compose.activity)
                api(libs.appCompat)
                api(libs.androidX.core)
                implementation(libs.koin.android)
                implementation(libs.coil)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.darwin)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
