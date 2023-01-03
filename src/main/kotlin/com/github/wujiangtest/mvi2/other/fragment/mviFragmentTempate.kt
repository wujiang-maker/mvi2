package com.github.wujiangtest.mvi2.other.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mviFragmentTemplate
    get() = template {
        name = "Mvi Fragment"
        description = "适用于Mvi框架的Fragment"
        minApi = MIN_API
//        minBuildApi = MIN_API
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val fragmentClass = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val contentDescribe = stringParameter {
            name = "页面描述"
            default = ""
            help = "请描述页面相关功能"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${fragmentToLayout(fragmentClass.value)}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(fragmentClass),
            TextFieldWidget(contentDescribe),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mviFragmentRecipe(
                data as ModuleTemplateData,
                fragmentClass.value,
                contentDescribe.value,
                layoutName.value,
                packageName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.hideout.wallet"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }