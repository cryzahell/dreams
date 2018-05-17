package com.ox.dream.dreams.base

/**
 * @author Administrator
 * @date 2017/8/10 0010
 * 一个界面的基本操作流程
 */
interface BaseUIFlow {
    /**
     * return获取布局id
     */
    val layout: Int

    /**
     * 初始化数据
     */
    fun initVariable()

    /*
    * 初始化view
    * */
    fun initView()

    /**
     * 监听
     */
    fun initListener()

}
