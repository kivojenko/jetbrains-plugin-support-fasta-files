plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.2.0"
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
        intellijIdeaCommunity("2024.3.1.1")
        bundledPlugin("com.intellij.java")
        pluginVerifier()
        plugin("PsiViewer:243.7768")
    }
    implementation("org.biojava:biojava-core:7.1.3")
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