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

## License
```
Copyright 2020 JayaKrishnan Nair

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
