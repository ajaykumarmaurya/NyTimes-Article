package com.newyorktimes.newsapp.data.remote.response

/****
 * ResponseListener callback which is responsible for giving the API response back to the presentation layer
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
interface ResponseListener<T> {
    fun onStart()
    fun onFinish()
    fun onResponse(result: ApiResponse<T>)
}