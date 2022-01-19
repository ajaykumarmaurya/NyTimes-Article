package com.newyorktimes.newsapp.view.listeners

/****
 * Back press listener for handling back navigation in activity/fragments
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
interface BackPressListener {
    fun onBackPress(): Boolean
}