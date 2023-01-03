package other.fragment.src.app_package

import other.PathConst
import java.text.SimpleDateFormat
import java.util.*

fun mviViewModel(
    packageName:String,
    fragmentClass:String,
    layoutName:String,
)="""
package ${packageName}.${layoutName.replace("fragment_","")}
import android.app.Application
import ${PathConst.BaseViewModelPath}

/**
 *@description $fragmentClass
 *@author 吴江
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${fragmentClass}ViewModel(application: Application):BaseViewModel(application){

    /**
     *意图事件分发
     */
    fun dispatchAction(action: ${fragmentClass}Activity.${fragmentClass}Action) {
    
    }

}
"""