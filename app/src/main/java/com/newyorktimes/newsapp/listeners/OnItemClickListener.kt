package com.newyorktimes.newsapp.listeners

import com.newyorktimes.newsapp.view.fragment.news.NewsItemViewModel

/****
 * News List item click listener
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
interface OnItemClickListener {
    fun onItemClick(item: NewsItemViewModel)
}