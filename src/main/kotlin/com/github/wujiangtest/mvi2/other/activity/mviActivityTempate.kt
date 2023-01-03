package com.github.wujiangtest.mvi2.other.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.wujiangtest.mvi2.other.PathConst

val mviActivityTemplate
    get() = template {
        name = "Mvi Activity"
        description = "适用于Mvi框架的Activity"
        minApi = MIN_API
        category = Category.Other
        formFactor = FormFactor.Mobile

        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter


        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Main"
            help = "只输入名字，不要包含Activity"
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
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value)}" }
        }
        val packageName = defaultPackageNameParameter
        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(contentDescribe),
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
        recipe = { data: TemplateData ->
            mviActivityRecipe(
                data as ModuleTemplateData, activityClass.value,contentDescribe.value, layoutName.value, packageName.value
            )
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