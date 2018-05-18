package com.ox.dream.dreams.fragment

import com.ox.dream.dreams.R
import com.ox.dream.dreams.base.BaseFragment
import kotlinx.android.synthetic.main.fg_home_tab3.*

class FgTab3 : BaseFragment() {
    override val layout: Int
        get() = R.layout.fg_home_tab3

    override fun initVariable() {

    }

    override fun initView() {
        fg_home_tab3_text.text = "fragment home tab3"
    }

    override fun initListener() {

    }


}
