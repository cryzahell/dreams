package com.ox.dream.dreams.custome

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.ox.dream.dreams.R

class TwoNumPicker : FrameLayout {


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    private lateinit var ivLeft: ImageView
    private lateinit var ivRight: ImageView
    private val rectl: Rect = Rect()

    @SuppressLint("ClickableViewAccessibility")
    private fun init(context: Context) {
        ivLeft = ImageView(context).apply {
            setBackgroundColor(Color.parseColor("#35bab0"))
            layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
            setImageResource(R.mipmap.ic_launcher_round)
        }
        addView(ivLeft)

        ivRight = ImageView(context).apply {
            setBackgroundColor(Color.parseColor("#35bab0"))
            layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
            setImageResource(R.mipmap.ic_launcher_round)
        }
        addView(ivRight)

    }

    private var canmove: Boolean = false
    private var lastX: Int = 0
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event!!.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                val contains = rectl.contains(x, y)
                canmove = contains
            }
            MotionEvent.ACTION_MOVE -> if(canmove) {
//                testl += x - lastX
                testl = x
                testl = if (testl < 0) 0 else testl
                requestLayout()
                println(testl)
                lastX = x
            }
            MotionEvent.ACTION_UP -> {
                testl = 0
                canmove = false
                requestLayout()
                println("www.baidu.com")
            }
        }
        return true
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }


    private var testl: Int = 0

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {

        val mw = measuredWidth
        val mh = measuredHeight

        val ll = paddingLeft + testl
        val tl = paddingTop
        val rl = paddingLeft + ivLeft.measuredWidth + testl
        val bl = tl + ivLeft.measuredWidth
        ivLeft.layout(ll, tl, rl, bl)
        rectl.set(ll, tl, rl, bl)

        ivRight.layout(mw - paddingLeft - ivRight.measuredWidth, tl, mw - paddingLeft, tl + ivRight.measuredHeight)
    }


}
