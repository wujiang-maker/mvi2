package com.github.wujiangtest.mvi2.other.adapter.res.layout
fun mviAdapterXml(
    packageName: String,
    activityClass: String,
    layoutName: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
             name="item"
             type="${packageName}.${activityClass}"/>
    </data>
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">



    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""