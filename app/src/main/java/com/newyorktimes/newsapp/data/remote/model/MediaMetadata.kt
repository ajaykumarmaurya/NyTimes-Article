package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Media Metadata class
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
data class MediaMetadata(@SerializedName("url") var imageUrl : String? = "",
                         @SerializedName("format") var format: String? = "")