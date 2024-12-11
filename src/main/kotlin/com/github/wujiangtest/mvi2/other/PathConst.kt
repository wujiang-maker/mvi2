package com.github.wujiangtest.mvi2.other

import org.gradle.internal.impldep.com.google.common.base.CaseFormat
import java.io.File

object PathConst {
    //    const val BaseVmActivityPath = "com.yjkj.chainup.newVersion.base.BaseVmActivity"
    const val BaseVmActivityPath = "com.bit.app.base.core.android.BaseVmActivity"

    //    const val BaseVmFragmentPath = "com.hideout.lib_base.common.mvi.base.BaseVmFragment"
    const val BaseVmFragmentPath = "com.bit.app.base.core.android.BaseVmFragment"

    //    const val BaseViewModelPath = "com.hideout.lib_base.common.mvi.base.BaseViewModel"
    const val BaseViewModelPath = "com.yjkj.vm.viewModel.BaseViewModel"
//    const val BaseViewModelPath = "com.bit.app.base.core.android.BaseViewModel"
    const val PluginUserName = "jasen-Android"//插件使用者

    /**
     * 下划线转驼峰
     */
    fun transferPagePackage(layoutName: String): String {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, layoutName)
    }

    /**
     * 驼峰转下划线
     */
    fun transferPagePackage2(layoutName: String): String {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, layoutName)
    }

    /**
     * 转化manifest路径
     */
    fun getManifestSet(packageName: String, filePath: String): String {
        var path = filePath.replace("\\", ".").plus("packageName-->$packageName")
//        val data = path.replace(packageName, " ").split(" ")
        return path
    }
}