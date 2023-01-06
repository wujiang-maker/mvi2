package com.github.wujiangtest.mvi2.other.adapter.src.app_package
import java.text.SimpleDateFormat
import java.util.*

fun mviAdapterKt(
    applicationPackage: String?,
    activityClass: String,
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
 *@author 吴江
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${activityClass}Adapter:BaseQuickAdapter<UserInfo,BaseDataBindingHolder<ItemUserInfoBinding>>(R.layout.${layoutName}) {
    override fun convert(holder: BaseDataBindingHolder<ItemUserInfoBinding>, item: UserInfo) {

        holder.dataBinding?.item = item
    }
}
"""