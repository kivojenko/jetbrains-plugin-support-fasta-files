plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.2.0"
}

group = "com.kivojenko.plugin.display"
version = "1.0-SNAPSHOT"
sourceSets["main"].java.srcDirs("src/main/gen")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        pycharmProfessional("2024.3")
        bundledPlugin("Pythonid")
        plugin("PsiViewer:243.7768")
    }
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}


intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "231"
        }
    }
}