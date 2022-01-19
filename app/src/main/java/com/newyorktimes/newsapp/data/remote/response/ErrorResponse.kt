package com.newyorktimes.newsapp.data.remote.response

import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the error response
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
data class ErrorResponse (@SerializedName("errorCode") var errorCode:  String = "",
                          @SerializedName("errorDescription") var errorDescription: String = "")