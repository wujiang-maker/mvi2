package com.github.wujiangtest.mvi2.other.fragment.res.layout

import com.github.wujiangtest.mvi2.other.PathConst

fun mviFragmentXml(
    packageName: String, fragmentClass: String, layoutName: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="vm"
            type="${packageName}.${fragmentClass.decapitalize()}.${fragmentClass}ViewModel" />
            
           <variable
            name="click"
            type="${packageName}.${fragmentClass.decapitalize()}.${fragmentClass}Fragment.ClickProxy" />        
    </data>
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
          android:fitsSystemWindows="true">
 <com.yjkj.chainup.newVersion.widget.MyTitleView
            android:id="@+id/mtv_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:titleText="" />


    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""