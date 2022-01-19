package com.newyorktimes.newsapp.view.fragment.news

import androidx.lifecycle.Observer
import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.databinding.FragmentNewsListBinding
import com.newyorktimes.newsapp.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_news_list.*


/****
 * News List fragment
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class NewsListFragment : BaseFragment<NewsListViewModel, FragmentNewsListBinding>() {

    override fun getTitle(): String {
        return getString(R.string.app_name)
    }

    override val layoutRes: Int
        get() = R.layout.fragment_news_list

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun getViewModel(): Class<NewsListViewModel> {
        return NewsListViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadNews()
        viewModel.emptyListEvent.observe(this, Observer {
            if(it)
                empty_view.visibility = View.VISIBLE
            else
                empty_view.visibility = View.GONE
        })

        viewModel.filterText.observe(this, Observer {
            viewModel.filterText.value?.let { it1 ->
                viewModel.filterNews(it1)
            }
        })
    }

    override fun observeNavigationEvent() {
        super.observeNavigationEvent()
        viewModel.navigateToDetails.observe(this, androidx.lifecycle.Observer {
            it?.let {
                navigateToDetails(it)
            }
        })
    }

    override fun observeServiceError() {
        super.observeServiceError()
        viewModel.serviceErrorEvent.observe(this, Observer {
            it?.let{
                showErrorDialog(it)
            }
        })
    }

    private fun navigateToDetails(url: String?) {
        val builder = CustomTabsIntent.Builder()
        activity?.let {
            builder.setToolbarColor(ContextCompat.getColor(it, R.color.colorPrimary))
            builder.setStartAnimations(it, R.anim.anim_enter, R.anim.anim_exit)
        }

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(activity as FragmentActivity, Uri.parse(url))
    }


}