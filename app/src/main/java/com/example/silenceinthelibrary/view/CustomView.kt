package com.example.silenceinthelibrary.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.example.silenceinthelibrary.R


class CustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var displayName: String?

    init {
        context.theme.obtainStyledAttributes(attrs,
            R.styleable.CustomView,
            0,
            0).apply {
            try {
                displayName = getString(R.styleable.CustomView_displayName)
            } finally {
                recycle()
            }
        }
    }

    fun setDisplayName(name: String) {
        displayName = name
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas.apply {
        }
    }
}