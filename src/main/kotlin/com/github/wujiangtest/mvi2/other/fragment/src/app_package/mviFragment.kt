package com.github.wujiangtest.mvi2.other.fragment.src.app_package

import com.github.wujiangtest.mvi2.other.PathConst
import java.text.SimpleDateFormat
import java.util.*

fun mviFragmentKt(
    applicationPackage:String?,
    fragmentClass:String,
    contentDescribe:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.${ PathConst.transferPagePackage(
    layoutName.replace(
        "fragment_", ""
    )
)}
import ${PathConst.BaseVmFragmentPath}
import  ${applicationPackage}.R
import android.os.Bundle
import  ${applicationPackage}.databinding.Fragment${fragmentClass}Binding


/**
 *@description $contentDescribe
 *@author ${PathConst.PluginUserName} 
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${fragmentClass}Fragment:BaseVmFragment<${fragmentClass}ViewModel,Fragment${fragmentClass}Binding>(R.layout.${layoutName}) {

    private val proxy: ClickProxy by lazy {
        ClickProxy()
    }

    /**
     * 初始化view
     */
    override fun initWidget(savedInstanceState: Bundle?) {
        mViewBinding.vm = mViewModal
        mViewBinding.click = proxy
        
    }

    /**
     * 加载网络数据
     */
    override fun loadData() {
    
    }
    
    /**
     * 懒加载网络数据
     */
    override fun lazyLoadData() {
    
    }
    
    /**
     *添加vm观察者
     */
    override fun createObserver() {
    
    }
    
     /**
     * 页面Intent意图
     */
    sealed class ${fragmentClass}Action {
    
    }
    
    /**
     * 点击事件代理
     */
    inner class ClickProxy{

    }
}    
"""