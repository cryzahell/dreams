package com.ox.dream.dreams.fragment

import com.ox.dream.dreams.R
import com.ox.dream.dreams.base.BaseFragment
import kotlinx.android.synthetic.main.fg_home_tab2.*

class FgTab2 : BaseFragment() {
    override val layout: Int
        get() = R.layout.fg_home_tab2

    override fun initVariable() {

    }

    override fun initView() {
        fg_home_tab2_text.text = "fragment home tab2"
    }

    override fun initListener() {

    }


}
