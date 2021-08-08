# GitHooksTeam

* Gradle Plugin that helps you automate setting up git hooks.
* Using a folder not associated with `.git` helps you share setup with your team on VCS.

![](https://github.com/jknair0/GitHooksTeam/actions/workflows/test-deploy.yml/badge.svg) 
[![](https://img.shields.io/static/v1?label=gradle-portal&message=v1.2.0&color=green)](https://plugins.gradle.org/plugin/tech.jknair.githooksteam)

## Setup

Using the plugins DSL:
```groovy
plugins {
  id "tech.jknair.githooksteam" version "1.2.0"
}
```

Using legacy plugin:

```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.tech.jknair.githooksteam:githooksteamplugin:1.2.0"
  }
}

apply plugin: "tech.jknair.githooksteam"
```



## Setup hooks path (Optional)

By default plugin takes `${project.rootDir}/.githooks` as hooks directory.

You can setup your custom path as follows:

build.gradle[.kts]

```groovy
gitHooksTeamPlugin {
    srcDir = "your custom path here"
}
```

Plugin set up reference: https://plugins.gradle.org/plugin/tech.jknair.githooksteam

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
