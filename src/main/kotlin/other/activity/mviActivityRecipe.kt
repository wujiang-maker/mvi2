package other.activity

import  com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.activity.res.layout.mviActivityXml
import other.activity.src.app_package.mviActivityKt
import other.activity.src.app_package.mviActivityViewModel


fun RecipeExecutor.mviActivityRecipe(
    moduleData: ModuleTemplateData, activityClass: String, layoutName: String, packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = "${packageName}.${layoutName.replace("activity_", "")}",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
    )

    val mviActivity =
        mviActivityKt(projectData.applicationPackage, activityClass, layoutName, packageName)
    // 保存Activity
    save(
        mviActivity,
        srcOut.resolve(
            "${
                layoutName.replace(
                    "activity_",
                    ""
                )
            }/${activityClass}Activity.${ktOrJavaExt}"
        )
    )

    // 保存xml
    save(
        mviActivityXml(packageName, activityClass, layoutName),
        resOut.resolve("layout/${layoutName}.xml")
    )
    // 保存viewmodel
    save(
        mviActivityViewModel(packageName, activityClass, layoutName),
        srcOut.resolve(
            "${
                layoutName.replace(
                    "activity_",
                    ""
                )
            }/${activityClass}ViewModel.${ktOrJavaExt}"
        )
    )
}