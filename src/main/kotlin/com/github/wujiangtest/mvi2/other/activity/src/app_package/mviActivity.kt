package com.github.wujiangtest.mvi2.other.activity.src.app_package

import com.github.wujiangtest.mvi2.other.PathConst
import java.text.SimpleDateFormat
import java.util.*

fun mviActivityKt(
    applicationPackage: String?,
    activityClass: String,
    contentDescribe: String,
    layoutName: String,
    packageName: String
) = """
package ${packageName}.${ PathConst.transferPagePackage(
    layoutName.replace(
        "activity_", ""
    )
)}
import ${PathConst.BaseVmActivityPath}
import ${applicationPackage}.R
import android.os.Bundle
import ${applicationPackage}.databinding.Activity${activityClass}Binding


/**
 *@description $contentDescribe
 *@author 张明海
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
 
class ${activityClass}Activity:BaseVmActivity<${activityClass}ViewModel,Activity${activityClass}Binding>(R.layout.${layoutName}) {


    /**
     *添加vm观察者
     */
    override fun createObserver() {

    }
    
    /**
     * 初始化view
     */
      override fun initWidget(savedInstanceState: Bundle?) {
        mDataBinding.vm = mViewModel

    }

    /**
     * 加载网络数据
     */
    override fun loadData() {

    }
    
     /**
     * 页面Intent意图
     */
    sealed class ${activityClass}Action {
    
    }
}
"""