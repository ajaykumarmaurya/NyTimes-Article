package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the list of news
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
data class NewsListResponse(@SerializedName("results") var popularNewsList : ArrayList<NewsItem>? = ArrayList())