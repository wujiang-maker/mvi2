package com.github.wujiangtest.mvi2.services

import com.intellij.openapi.project.Project
import com.github.wujiangtest.mvi2.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
    fun getRandomNumber() = 4
}
