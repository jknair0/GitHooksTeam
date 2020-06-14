/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package tech.jknair.githooksteam

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'tech.jknair.githooksteam.greeting' plugin.
 */
class GitHooksTeamPluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("tech.jknair.githooksteam")

        // Verify the result
        assertNotNull(project.tasks.findByName(GitHooksTeamPlugin.TASK_NAME))
    }
}
