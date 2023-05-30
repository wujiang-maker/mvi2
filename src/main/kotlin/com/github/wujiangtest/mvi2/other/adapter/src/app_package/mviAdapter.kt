package com.github.wujiangtest.mvi2.other.adapter.src.app_package

import com.github.wujiangtest.mvi2.other.PathConst
import java.text.SimpleDateFormat
import java.util.*

fun mviAdapterKt(
    applicationPackage: String?,
    activityClass: String,
    entityClass: String,
    contentDescribe: String,
    layoutName: String,
    packageName: String
) = """

package ${packageName}
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Item${activityClass}Binding


/**
 *@description $contentDescribe
 *@author ${PathConst.PluginUserName}
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${activityClass}Adapter:BaseQuickAdapter<${entityClass},BaseDataBindingHolder<Item${activityClass}Binding>>(R.layout.${layoutName}) {
    override fun convert(holder: BaseDataBindingHolder<Item${activityClass}Binding>, item: ${entityClass}) {
        holder.dataBinding?.item = item
    }
}
"""