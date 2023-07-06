package com.github.wujiangtest.mvi2.other.adapter2.src.app_package
import com.github.wujiangtest.mvi2.other.PathConst
import java.text.SimpleDateFormat
import java.util.*
fun mviAdapterItemKt(
    applicationPackage: String?,
    activityClass: String,
    entityDescribe: String,
    layoutName: String,
    packageName: String
) = """
package $packageName

/**
 *@description $entityDescribe
 *@author ${PathConst.PluginUserName}
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
data class ${activityClass}(val info:String)

"""