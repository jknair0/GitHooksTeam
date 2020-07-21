# GitHooksTeam

* A Gradle Plugin which helps share and setup git hooks. The default githooks directory is `${projectRootDirectory}/.githooks`.
* The team can share githooks across team using git VCS by leaving the burden of setUp to GitHooksTeam Plugin.

## Setup

Using legacy plugin application is Recommended:

```
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.tech.jknair.githooksteam:githooksteamplugin:1.1.0"
  }
}

apply plugin: "tech.jknair.githooksteam"
```

In case you want to setup your own directory as githooks root add following setup to your module `build.gradle[.kts]` file.

```
gitHooksTeamPlugin {
    srcDir = "/* git hooks path here eg: */"
}
```

SetUp Reference: https://plugins.gradle.org/plugin/tech.jknair.githooksteam
