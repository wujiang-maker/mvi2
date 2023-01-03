package com.github.wujiangtest.mvi2.other.activity
import  com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.wujiangtest.mvi2.other.PathConst
import com.github.wujiangtest.mvi2.other.activity.res.layout.mviActivityXml
import com.github.wujiangtest.mvi2.other.activity.src.app_package.mviActivityKt
import com.github.wujiangtest.mvi2.other.activity.src.app_package.mviActivityViewModel

fun RecipeExecutor.mviActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    contentDescribe: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//        moduleData = moduleData,
//        activityClass = "${activityClass}Activity",
//        packageName = "${packageName}.${
//            PathConst.transferPagePackage(
//                layoutName.replace(
//                    "activity_", ""
//                )
//            )
//        }",
//        isLauncher = false,
//        hasNoActionBar = false,
//        generateActivityTitle = false,
//    )


    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = "${packageName}.ui.activity.${PathConst.transferPagePackage(
            layoutName.replace(
                "activity_", ""
            )
        )
        }",
//        packageName = "${packageName}.${
//            PathConst.getManifestSet(
//                packageName, srcOut.resolve(
//                    "${
//                        PathConst.transferPagePackage(
//                            layoutName.replace(
//                                "activity_", ""
//                            )
//                        )
//                    }"
//                ).absolutePath
//            )
//        }",
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false,
//            requireTheme = false,
//            useMaterial2 = false
    )


    val mviActivity = mviActivityKt(
        projectData.applicationPackage, activityClass, contentDescribe, layoutName, packageName
    )
    // 保存Activity
    save(
        mviActivity, srcOut.resolve(
            "${
                PathConst.transferPagePackage(
                    layoutName.replace(
                        "activity_", ""
                    )
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
        mviActivityViewModel(packageName, activityClass, layoutName), srcOut.resolve(
            "${
                PathConst.transferPagePackage(
                    layoutName.replace(
                        "activity_", ""
                    )
                )
            }/${activityClass}ViewModel.${ktOrJavaExt}"
        )
    )
}