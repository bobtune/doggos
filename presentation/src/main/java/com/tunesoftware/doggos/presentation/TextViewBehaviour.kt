package com.tunesoftware.doggos.presentation

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.widget.NestedScrollView

class TextViewBehaviour(context: Context, attrs: AttributeSet): CoordinatorLayout.Behavior<TextView>(context, attrs) {

    private var startY = 0
    private var startX = 0
    private var toolbarTitleX = 0

    override fun layoutDependsOn(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        (dependency as? Toolbar)?.let {
            toolbarTitleX = (it.contentInsetStart + it.titleMarginStart).toPx
        }
        return dependency is NestedScrollView
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        if (startY == 0) {
            startY = child.top
            startX = child.left
        }
        val percent = dependency.top.toFloat() / startY
        child.top = dependency.top
        child.left = (percent * startX).toInt() + ((1 - percent) * toolbarTitleX).toInt()
        child.alpha = percent
        Log.d("TextViewBehaviour", "onDependentViewChanged: ${child.top} ${dependency.top}")
        return true
    }

    val Int.toPx: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}