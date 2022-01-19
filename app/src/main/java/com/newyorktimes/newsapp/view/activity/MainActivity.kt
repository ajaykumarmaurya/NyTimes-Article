package com.newyorktimes.newsapp.view.activity

import android.os.Bundle
import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.ActivityMainBinding
import com.newyorktimes.newsapp.utils.FragmentUtils
import com.newyorktimes.newsapp.view.activity.base.BaseActivity
import com.newyorktimes.newsapp.view.fragment.news.NewsListFragment
import com.newyorktimes.newsapp.view.fragment.news.NewsListViewModel


/****
 * MainActivity class
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class MainActivity : BaseActivity<NewsListViewModel, ActivityMainBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<NewsListViewModel> {
      return NewsListViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentUtils.replaceFragment(this, NewsListFragment(), R.id.fragmentContainer,
            false, FragmentUtils.FragmentAnimation.TRANSITION_NONE)
    }

}
