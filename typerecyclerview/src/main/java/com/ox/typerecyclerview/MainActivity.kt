package com.ox.typerecyclerview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class type {
        text, image, last
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)

        val list = ArrayList<String>()
        for (i in 0 until 40) {
            list.add("data$i")
        }
        val adapter = object : RecyclerView.Adapter<VH>() {

            override fun onCreateViewHolder(p0: ViewGroup, position: Int): VH {
//                val itemViewType = getItemViewType(position)
                println("www.onCreate.com.${position}")

                if (position >= list.size - 1) {
                    val view = View(this@MainActivity)
                    view.setBackgroundColor(Color.BLUE)
                    view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50)
                    return VHLast(view)
                } else if (position % 2 == 0) {
                    val iv = ImageView(this@MainActivity)
                    iv.setImageResource(R.mipmap.ic_launcher)
                    return VHImage(iv)
                } else {
                    return VHText(layoutInflater.inflate(android.R.layout.simple_list_item_1, null))
                }
            }

            override fun getItemViewType(position: Int): Int {
                return position
            }

            override fun getItemCount(): Int {
                return list.size
            }

            override fun onBindViewHolder(vh: VH, position: Int) {
                when (vh) {
                    is VHText -> {
                        if (vh.itemView1 is TextView) {
                            (vh.itemView1 as TextView).text = list.get(position)
                        }
                    }
                    is VHImage -> {

                        if (vh.itemview2 is ImageView) {
                            (vh.itemview2 as ImageView).setImageResource(R.mipmap.ic_launcher)
                        }
                    }
                    is VHLast -> {

                    }
                }
            }

        }
        recycler.adapter = adapter

    }

    open inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class VHText(itemView: View) : VH(itemView) {
        var itemView1 = itemView

    }

    inner class VHImage(itemView: View) : VH(itemView) {
        var itemview2 = itemView
    }

    inner class VHLast(itemView: View) : VH(itemView) {
        var itemview3 = itemView
        var hasMeasure = false

        init {
//            println("www.init.com")
            itemView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    if (hasMeasure.not()) {
                        var ch = 0
                        for (i in 0 until recycler.childCount) {
                            ch += recycler.getChildAt(i).measuredHeight
                        }
                        itemView.viewTreeObserver.removeOnPreDrawListener(this)
                    }
                    return false
                }

            })
        }
    }

}

