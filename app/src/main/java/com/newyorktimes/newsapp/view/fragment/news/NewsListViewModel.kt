package com.newyorktimes.newsapp.view.fragment.news

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.newyorktimes.newsapp.BR
import com.newyorktimes.newsapp.R
import com.newyorktimes.newsapp.architecture.SingleLiveEvent
import com.newyorktimes.newsapp.data.remote.model.NewsListResponse
import com.newyorktimes.newsapp.data.remote.response.ApiResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.listeners.OnItemClickListener
import com.newyorktimes.newsapp.repository.NewsRepository
import com.newyorktimes.newsapp.viewmodel.BaseViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject

/****
 * The presentation layer of News List fragment
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class NewsListViewModel @Inject constructor(private val newsRepository: NewsRepository) : BaseViewModel(){

    val navigateToDetails =  SingleLiveEvent<String?>()
    val emptyListEvent = SingleLiveEvent<Boolean>()
    var shouldHideRefresh = MutableLiveData<Boolean>()
    val filterText = MutableLiveData<String>()
    private val actualItems = arrayListOf<NewsItemViewModel>()

    private var isSwipeToRefresh: Boolean = false

    /**
     * The Menu Item list.
     */
    val items: ObservableList<NewsItemViewModel> = ObservableArrayList<NewsItemViewModel>()

    /**
     * The Single item.
     */
    val itemBinding: ItemBinding<NewsItemViewModel> = ItemBinding.of<NewsItemViewModel> { itemBinding, position, item ->
        itemBinding.set(BR.itemViewModel, R.layout.item_news)
        itemBinding.bindExtra(BR.itemClickListener, object : OnItemClickListener {
            override fun onItemClick(item: NewsItemViewModel) {
                navigateToDetails.value = item.newsUrl.value
            }
        })
    }

    /**
     * Service call that fetches the list of news
     */
    fun loadNews(){
        items.clear()
        actualItems.clear()
        newsRepository.getNews(1, object :ResponseListener<NewsListResponse>{
            override fun onStart() {
                if(!isSwipeToRefresh)
                    loadingStatus.value = true
            }

            override fun onFinish() {
                loadingStatus.value = false
            }

            override fun onResponse(result: ApiResponse<NewsListResponse>) {
                shouldHideRefresh.value = true

                if(result.error == null && null != result.data){
                    emptyListEvent.value = false
                    prepareNewsList(result.data)
                }else{
                    emptyListEvent.value = true
                    serviceErrorEvent.value = result.errorDescription
                }
            }

        })
    }

    /**
     * Prepares the newslist observable for rendering
     * @param newsListResponse: NewsListResponse
     */
    private fun prepareNewsList(newsListResponse: NewsListResponse) {
        val newsItems = newsListResponse.popularNewsList?.let { it } ?: return
        for (newsItem in newsItems) {
            items.add(NewsItemViewModel(newsItem.title, newsItem.authors,
                newsItem.publishedDate, newsItem.url, newsItem.media!![0].mediaMetadata!![0].imageUrl))
        }
        actualItems.addAll(items)
    }


    /**
     * Method to be invoked on Swipe to refresh
     */
    fun swipeRefreshEvent() {
        isSwipeToRefresh = true
        loadNews()
    }


    /**
     * Method to filter the list based on user query
     */
    fun filterNews(query: String) {
        val filterItems = actualItems.filter { result ->
            result.newsTitle.value?.contains(query, ignoreCase = true) ?: true
        }
        items.clear()
        items.addAll(filterItems)
    }

}