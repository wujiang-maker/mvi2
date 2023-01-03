package other.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.fragment.res.layout.mviFragmentXml
import other.fragment.src.app_package.mviFragmentKt
import other.fragment.src.app_package.mviViewModel

fun RecipeExecutor.mviFragmentRecipe(
    moduleData: ModuleTemplateData,
    fragmentClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val mvvmFragment =
        mviFragmentKt(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    // 保存Activity
    save(
        mvvmFragment,
        srcOut.resolve(
            "${
                layoutName.replace(
                    "fragment_",
                    ""
                )
            }/${fragmentClass}Fragment.${ktOrJavaExt}"
        )
    )
    // 保存xml
    save(mviFragmentXml(packageName, fragmentClass,layoutName), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
    save(
        mviViewModel(packageName, fragmentClass,layoutName),
        srcOut.resolve(
            "${
                layoutName.replace(
                    "fragment_",
                    ""
                )
            }/${fragmentClass}ViewModel.${ktOrJavaExt}"
        )
    )
}