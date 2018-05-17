package com.ox.dream.dreams.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import java.io.Serializable
import java.util.ArrayList

/**
 * 基类
 */
class BaseFgPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm), Serializable {

    val list: MutableList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    fun addAll(collection: Collection<Fragment>) {
        list.addAll(collection)
        notifyDataSetChanged()
    }

    fun addWithoutNotify(fragment: Fragment) {
        list.add(fragment)
    }

    fun addWithNotity(fragment: Fragment) {
        addWithoutNotify(fragment)
        notifyDataSetChanged()
    }

}
