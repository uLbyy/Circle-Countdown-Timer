plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.vanniktech.maven.publish")
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("io.github.ulbyy", "circle-countdown-timer", "1.0.0")

    pom {
        name.set("Circle Countdown Timer")
        description.set("Circle Countdown timer for Compose")
        inceptionYear.set("2026")
        url.set("https://github.com/uLbyy/Circle-Countdown-Timer")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("uLbyy")
                name.set("Hüseyin Aslan")
                url.set("https://github.com/uLbyy")
            }
        }
        scm {
            url.set("https://github.com/uLbyy/Circle-Countdown-Timer")
            connection.set("scm:git:git://github.com/uLbyy/Circle-Countdown-Timer.git")
            developerConnection.set("scm:git:ssh://git@github.com/uLbyy/Circle-Countdown-Timer.git")
        }
    }
}

android {
    namespace = "com.butterknifelabs.countdown.timer.lib"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}