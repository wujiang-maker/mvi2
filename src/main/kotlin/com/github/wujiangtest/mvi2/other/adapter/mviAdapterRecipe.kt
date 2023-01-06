package com.github.wujiangtest.mvi2.other.adapter

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.wujiangtest.mvi2.other.adapter.res.layout.mviAdapterXml
import com.github.wujiangtest.mvi2.other.adapter.src.app_package.mviAdapterItemKt
import com.github.wujiangtest.mvi2.other.adapter.src.app_package.mviAdapterKt

fun RecipeExecutor.mviAdapterRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    contentDescribe: String,
    entityClass: String,
    entityDescribe: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val mviAdapter = mviAdapterKt(
        projectData.applicationPackage, activityClass, contentDescribe, layoutName, packageName
    )

    val mviEntity = mviAdapterItemKt(
        projectData.applicationPackage, entityClass, entityDescribe, layoutName, packageName
    )
    // 保存Adapter
    save(
        mviAdapter, srcOut.resolve(
            "${activityClass}Adapter.${ktOrJavaExt}"
        )
    )
    //保存实体
    save(
        mviEntity, srcOut.resolve(
            "${entityClass}.${ktOrJavaExt}"
        )
    )
    // 保存xml
    save(
        mviAdapterXml(packageName, entityClass, layoutName),
        resOut.resolve("layout/${layoutName}.xml")
    )
}