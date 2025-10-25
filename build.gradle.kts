plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.10.1"
}

group = "com.kivojenko.plugin.fasta"
version = "1.0.2"
sourceSets["main"].java.srcDirs("src/main/gen")

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        pycharmProfessional("2025.2.3")
        pluginVerifier()
        plugin("PsiViewer:252.23892.248")
    }
    implementation("org.biojava:core:1.9.6")
    implementation("org.biojava:biojava-core:7.2.2")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}


java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
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