package com.github.wujiangtest.mvi2.other.adapter.src.app_package
import java.text.SimpleDateFormat
import java.util.*
fun mviAdapterItemKt(
    applicationPackage: String?,
    activityClass: String,
    contentDescribe: String,
    layoutName: String,
    packageName: String
) = """
package $packageName

/**
 *@description $contentDescribe
 *@author 吴江
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
data class ${activityClass}(val info:String)

"""