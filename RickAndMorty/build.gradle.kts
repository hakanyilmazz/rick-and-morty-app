buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        Util.getVariablesOf(ClassPaths::class).forEach { classpath(it) }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}