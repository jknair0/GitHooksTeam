group = "tech.jknair.githooksteam"
version = "1.2.0"


plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("org.jetbrains.kotlin.jvm") version "1.3.70"
    id("com.gradle.plugin-publish") version "0.12.0"
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

gradlePlugin {
    plugins {
        create("gitHooksTeam") {
            displayName = "GitHooksTeam"
            description = "Automate the setup of git hooks as part of lifecycle with the source shared through VCS using Gradle"
            id = "tech.jknair.githooksteam"
            implementationClass = "tech.jknair.githooksteam.GitHooksTeamPlugin"
        }
    }
}

pluginBundle {
    website = "https://jknair.tech/"
    vcsUrl = "https://github.com/kjknair/GitHooksTeam"
    tags = listOf("git", "hooks", "gradle")
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations.getByName("functionalTestImplementation").extendsFrom(configurations.getByName("testImplementation"))

// Add a task to run the functional tests
val functionalTest by tasks.creating(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
}

val check by tasks.getting(Task::class) {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}
