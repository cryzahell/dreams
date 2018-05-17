package com.ox.dream.dreams.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Administrator
 * @date 2017/9/15 0015
 */
abstract class BaseFragment : Fragment(), BaseUIFlow {
    var contentView: View? = null
        protected set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (contentView == null) {
            contentView = LayoutInflater.from(context).inflate(layout, container, false);
        } else {
            if (contentView!!.parent != null) {
                (contentView!!.parent as ViewGroup).removeView(contentView)
            }
        }
        return contentView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.contentView = view
        initVariable()
        initView()
        initListener()
    }
}
