buildscript {
    dependencies {
        classpath(files("../githooksteam/build/libs/githooksteam-1.0.0.jar"))
    }
}

plugins {
    java
}

apply<tech.jknair.githooksteam.GitHooksTeamPlugin>()