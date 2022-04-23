plugins {
    Util.getVariablesOf(Plugins::class).forEach { id(it) }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    Util.getVariablesOf(KaptLibs::class).forEach { kapt(it) }
    Util.getVariablesOf(Dependencies::class).forEach { implementation(it) }
    Util.getVariablesOf(TestDependencies::class).forEach { testImplementation(it) }
    Util.getVariablesOf(AndroidTestDependencies::class).forEach { androidTestImplementation(it) }
}