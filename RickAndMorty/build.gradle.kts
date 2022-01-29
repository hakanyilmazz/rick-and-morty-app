buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        Util.toList(ClassPaths::class).forEach { classpath(it) }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}