package com.newyorktimes.newsapp.repository

import com.newyorktimes.newsapp.data.remote.Api
import com.newyorktimes.newsapp.data.remote.model.NewsListResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.schedulers.SchedulerContract
import javax.inject.Inject

/****
 * User Repository which keeps all the service calls related to User entity
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class NewsRepository@Inject constructor(private val api: Api, scheduler: SchedulerContract)
    : BaseRepository(scheduler){


    /**
     * This method calls the service for getting the list of news.
     * @param index - Index number of the news list
     * @param responseListener: Response Listener Callback
     */
    fun getNews(index : Int, responseListener: ResponseListener<NewsListResponse>){
        performRequest(api.getPopularNews(index), responseListener)
    }

}