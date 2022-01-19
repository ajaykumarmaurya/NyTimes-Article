package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Data model representing a single news item
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
data class NewsItem (@SerializedName("id") var id: Long? = 0,
                     @SerializedName("title") var title: String? = "",
                     @SerializedName("byline") var authors: String? = "",
                     @SerializedName("published_date") var publishedDate: String? = "",
                     @SerializedName("url") var url: String? = "",
                     @SerializedName("media") var media: ArrayList<Media>? = ArrayList())