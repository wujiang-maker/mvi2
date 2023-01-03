package other.fragment.src.app_package

import other.PathConst
import java.text.SimpleDateFormat
import java.util.*

fun mviFragmentKt(
    applicationPackage:String?,
    fragmentClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.${layoutName.replace("fragment_","")}
import ${PathConst.BaseVmFragmentPath}
import  ${applicationPackage}.R
import android.os.Bundle
import  ${applicationPackage}.databinding.Fragment${fragmentClass}Binding
import ${packageName}.${layoutName.replace("fragment_","")}.${fragmentClass}ViewModel


/**
 *@description $fragmentClass
 *@author 吴江
 *@data ${SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss").format(Date())}
 */
class ${fragmentClass}Fragment:BaseVmFragment<${fragmentClass}ViewModel,Fragment${fragmentClass}Binding>(R.layout.${layoutName}) {

    /**
     * 初始化view
     */
    override fun initWidget(savedInstanceState: Bundle?) {
        mViewBinding.vm = mViewModal
        
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
}    
"""