package com.github.wujiangtest.mvi2.other.adapter2

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mviAdapter2Template
    get() = template {
        name = "Mvi Adapter2"
        description = "适用于Mvi框架的Adapter"
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
        val adapterClass = stringParameter {
            name = "AdapterItem Name"
            default = ""
            help = "请输入Adapter名称"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val adapterDescribe = stringParameter {
            name = "Adapter Description"
            default = ""
            help = "请描述Adapter相关功能"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val entityClass = stringParameter {
            name = "Entity Name"
            default = "Entity"
            help = "请输入Entity名称"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${adapterClass.value}" }
        }
        val entityDescribe = stringParameter {
            name = "Entity Description"
            default = ""
            help = "请描述Entity相关功能"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = ""
            help = "请输入item布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "item_${activityToLayout(adapterClass.value).replace("activity_", "")}" }
        }
        val packageName = defaultPackageNameParameter
        widgets(
            TextFieldWidget(adapterClass),
            TextFieldWidget(adapterDescribe),
            TextFieldWidget(entityClass),
            TextFieldWidget(entityDescribe),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
        recipe = { data: TemplateData ->
            mviAdapterRecipe(
                data as ModuleTemplateData,
                "Item".plus(adapterClass.value),
                adapterDescribe.value,
                entityClass.value,
                entityDescribe.value,
                layoutName.value,
                packageName.value
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