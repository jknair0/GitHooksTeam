package tech.jknair.githooksteam

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Exec

open class GitHooksTeamPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create(PLUGIN_NAME, GitHooksTeamExtension::class.java)
        val srcDir = extension.srcDir ?: getDefaultSrcDir(project)
        val destDir = getHooksDir(project)
        project.tasks.create(TASK_NAME, Copy::class.java) {
            from(srcDir)
            into(destDir)
            doLast {
                logger.info("copied hooks from $srcDir to $destDir")
                createAddFileExecPermissionTask(project, destDir)
            }
        }
        if (project.tasks.findByName("build") != null) {
            project.tasks.named("build") {
                dependsOn(TASK_NAME)
            }
        }
    }

    private fun getDefaultSrcDir(project: Project): String {
        return "${project.rootDir}/.githooks"
    }

    private fun getHooksDir(project: Project): String {
        return "${project.rootDir}/.git/hooks"
    }

    private fun createAddFileExecPermissionTask(project: Project, dirPath: String): Exec {
        return project.tasks.create("addExecutePermission", Exec::class.java) {
            project.file(dirPath).listFiles()?.forEach { file ->
                val filePathStr = file.absolutePath
                commandLine("chmod", "+x", filePathStr)
                logger.debug("added execute permission for $filePathStr")
            }
        }
    }

    companion object {
        const val TASK_NAME = "setUpGitHooks"
        private const val PLUGIN_NAME = "gitHooksTeamPlugin"
    }

}