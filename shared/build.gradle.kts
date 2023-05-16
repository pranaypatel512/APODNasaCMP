import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.compose.compose

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
                implementation(compose.ui)
                implementation(compose("org.jetbrains.compose.ui:ui-util"))
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
                implementation(libs.koin.core)
                implementation(libs.essenty.parcelable)
                api(libs.decompose)
                implementation(libs.decompose.compose.multiplatform)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.serialization.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.aakira.napier)
                implementation(libs.multiplatform.settings.noArg)
                implementation(libs.multiplatform.settings.coroutines)
                //implementation(libs.decompose.router)

            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.androidx.appcompat)
                api(libs.androidx.activityCompose)
                api(libs.compose.uitooling)
                api(libs.kotlinx.coroutines.android)
                api(libs.koin.android)
                api(libs.coil.compose)
                implementation(libs.ktor.client.okhttp)
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
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.pranay.aPODNasaKMP"

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

buildConfig {
    val apiKey: String = gradleLocalProperties(rootDir).getProperty("apiKey")
    require(apiKey.isNotEmpty()) {
        "Register your api key from https://api.nasa.gov/#signUp and place it in local.properties as `apiKey`"
    }
    buildConfigField("String", "API_KEY", apiKey)
}
