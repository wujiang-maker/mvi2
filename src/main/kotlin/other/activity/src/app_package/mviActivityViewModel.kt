package other.activity.src.app_package

import other.PathConst
import java.text.SimpleDateFormat
import java.util.*
fun mviActivityViewModel(
    packageName: String,
    activityClass: String,
    layoutName:String,
) = """
package ${packageName}.${layoutName.replace("activity_","")}
import android.app.Application
import ${PathConst.BaseViewModelPath}

/**
 *@description $activityClass
 *@author 吴江
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${activityClass}ViewModel(application: Application):BaseViewModel(application){

    /**
     *意图事件分发
     */
    fun dispatchAction(action: ${activityClass}Activity.${activityClass}Action) {
    
    }

}
"""