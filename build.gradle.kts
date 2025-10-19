plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.9.0"
}

group = "com.kivojenko.plugin.fasta"
version = "1.0.0"
sourceSets["main"].java.srcDirs("src/main/gen")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdea("2025.1.2")
        bundledPlugin("com.intellij.java")
        pluginVerifier()
        plugin("PsiViewer:2025.1")
    }
    implementation("org.biojava:biojava-core:7.2.2")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


tasks {
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}


intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "231"
        }
    }
}