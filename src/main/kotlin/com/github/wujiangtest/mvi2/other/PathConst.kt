package com.github.wujiangtest.mvi2.other

import org.gradle.internal.impldep.com.google.common.base.CaseFormat
import java.io.File

object PathConst {
    val BaseVmActivityPath = "com.hideout.wallet.mvi.base.BaseVmActivity"
    val BaseVmFragmentPath = "com.hideout.wallet.mvi.base.BaseVmFragment"
    val BaseViewModelPath = "com.hideout.wallet.mvi.base.BaseViewModel"

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
        var path = filePath.replace("\\", ".")
//        return path.replace(packageName,"_").split("_")[1]
//        path = path.substring(path.indexOf(packageName))
        return path
    }
}