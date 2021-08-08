package tech.jknair.githooksteam

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.slf4j.Logger
import java.io.File

open class GitHooksTeamPlugin : Plugin<Project> {

    private lateinit var logger: Logger

    override fun apply(project: Project) {
        val extension = project.extensions.create(PLUGIN_NAME, GitHooksTeamExtension::class.java)
        val projectRootDir = project.rootDir.toString()
        val projectGitHooksDir = extension.srcDir ?: getDefaultSrcDir(projectRootDir)
        val gitHooksDir = getHooksDir(projectRootDir)
        logger = project.logger
        project.afterEvaluate {
            copyDirectory(projectGitHooksDir, gitHooksDir)
            makeAllFilesExecutable(gitHooksDir)
            logger.lifecycle("> updated git-hooks from $projectGitHooksDir")
        }
    }

    private fun getDefaultSrcDir(rootDirPath: String): String {
        return "${rootDirPath}${File.separator}.githooks"
    }

    private fun getHooksDir(rootDirPath: String): String {
        return "${rootDirPath}${File.separator}.git${File.separator}hooks"
    }

    private fun copyDirectory(srcDir: String, destDir: String) {
        val srcDirFile = File(srcDir)
        val destDirFile = File(destDir)
        srcDirFile.copyRecursively(destDirFile, overwrite = true)
    }

    private fun makeAllFilesExecutable(folderDirPath: String) {
        val dirFile = File(folderDirPath)
        dirFile.listFiles()?.forEach { file ->
            file.setExecutable(true)
        }
    }

    companion object {
        private const val PLUGIN_NAME = "gitHooksTeamPlugin"
    }

}