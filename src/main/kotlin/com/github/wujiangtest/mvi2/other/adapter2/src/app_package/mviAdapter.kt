package com.github.wujiangtest.mvi2.other.adapter2.src.app_package

import com.github.wujiangtest.mvi2.other.PathConst
import java.text.SimpleDateFormat
import java.util.*


/**
 * class ${activityClass}Adapter:BaseQuickAdapter<${entityClass},BaseDataBindingHolder<Item${activityClass}Binding>>(R.layout.${layoutName}) {
override fun convert(holder: BaseDataBindingHolder<Item${activityClass}Binding>, item: ${entityClass}) {
holder.dataBinding?.item = item
}
}
 */
fun mviAdapterKt(
    applicationPackage: String?,
    activityClass: String,
    entityClass: String,
    contentDescribe: String,
    layoutName: String,
    packageName: String
) = """

package $packageName
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import ${applicationPackage}.R
import ${applicationPackage}.databinding.${activityClass}Binding
import ${applicationPackage}.exchange.utils.convertBinding

/**
 *@description $contentDescribe
 *@author ${PathConst.PluginUserName}
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
 
 class ${activityClass}Adapter:BaseQuickAdapter<${entityClass},BaseViewHolder>(R.layout.${layoutName}) {
 
    override fun convert(helper: BaseViewHolder, item: ${entityClass}) {

      convertBinding<${activityClass}Binding>(helper.itemView)?.let {mBinding->
         mBinding.item = item
      }
    }
}

"""