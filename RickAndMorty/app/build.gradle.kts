plugins {
    Util.toList(Plugins::class).forEach { id(it) }
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        buildConfigField(
            String::class.java.simpleName,
            PropertyNames.baseUrl,
            properties[PropertyNames.baseUrl].toString()
        )

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    Util.toList(KaptLibs::class).forEach { kapt(it) }
    Util.toList(Dependencies::class).forEach { implementation(it) }
    Util.toList(TestDependencies::class).forEach { testImplementation(it) }
    Util.toList(AndroidTestDependencies::class).forEach { androidTestImplementation(it) }
}