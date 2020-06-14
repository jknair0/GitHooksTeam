# GitHooksTeam

* A Gradle Plugin which helps share and setup git hooks. The default githooks directory is `${projectRootDirectory}/.githooks`.
* The team can share githooks across team using git VCS by leaving the burden of setUp to GitHooksTeam Plugin.


In case you want to setup your own directory as githooks root add this to your `build.gradle[.kts]` file.

```
gitHooksTeamPlugin {
    srcDir = "/* git hooks path here*/"
}
```
