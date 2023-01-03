package com.github.wujiangtest.mvi2.other

import org.gradle.internal.impldep.com.google.common.base.CaseFormat

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
}