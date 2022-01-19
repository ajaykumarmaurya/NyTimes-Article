package com.newyorktimes.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

/****
 * Media Data Model
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
data class Media(@SerializedName("media-metadata") var mediaMetadata: ArrayList<MediaMetadata>? = ArrayList())
