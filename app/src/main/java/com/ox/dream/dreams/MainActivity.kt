package com.ox.dream.dreams

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ox.dream.dreams.base.BaseFgPagerAdapter
import com.ox.dream.dreams.fragment.FgTab1
import kotlinx.android.synthetic.main.activity_main.*

const val PAGE_TAB1 = 0
const val PAGE_TAB2 = 1
const val PAGE_TAB3 = 2
const val PAGE_TAB4 = 3

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v!!.id) {
            this.home_btn_1.id -> {
                home_vp.currentItem = PAGE_TAB1
            }
            this.home_btn_2.id -> {
                home_vp.currentItem = PAGE_TAB2
            }
            this.home_btn_3.id -> {
                home_vp.currentItem = PAGE_TAB3
            }
            this.home_btn_4.id -> {
                home_vp.currentItem = PAGE_TAB4
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_btn_1.text = getString(R.string.home_tab1)
        home_btn_2.text = getString(R.string.home_tab2)
        home_btn_3.text = getString(R.string.home_tab3)
        home_btn_4.text = getString(R.string.home_tab4)

        home_btn_1.setOnClickListener(this)
        home_btn_2.setOnClickListener(this)
        home_btn_3.setOnClickListener(this)
        home_btn_4.setOnClickListener(this)

        initPages()


    }

    private fun initPages() {
        var adapter = BaseFgPagerAdapter(supportFragmentManager)
        home_vp.adapter = adapter
        var fgs = ArrayList<Fragment>()
        fgs.add(FgTab1())
        fgs.add(FgTab1())
        fgs.add(FgTab1())
        fgs.add(FgTab1())
        adapter.addAll(fgs)
    }

}
