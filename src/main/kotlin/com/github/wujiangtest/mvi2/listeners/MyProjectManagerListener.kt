package com.github.wujiangtest.mvi2.listeners
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.github.wujiangtest.mvi2.services.MyProjectService
internal class MyProjectManagerListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        projectInstance = project
        project.service<MyProjectService>()
    }

    override fun projectClosed(project: Project) {
        projectInstance = null
        super.projectClosed(project)
    }

    companion object {
        var projectInstance: Project? = null
    }
}
