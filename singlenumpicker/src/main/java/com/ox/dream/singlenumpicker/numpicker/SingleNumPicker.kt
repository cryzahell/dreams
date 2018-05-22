package com.ox.dream.singlenumpicker.numpicker

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class SingleNumPicker : View {
    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    private fun init(context: Context) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


}
