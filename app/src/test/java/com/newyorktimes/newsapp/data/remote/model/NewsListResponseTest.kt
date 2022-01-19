package com.newyorktimes.newsapp.data.remote.model

import org.junit.Test
import org.junit.Assert.*

/****
 * File Description
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class NewsListResponseTest {
    var newsListResponse: NewsListResponse? = null;

    @Test
    fun testObject(){
        assertNull(newsListResponse)
        newsListResponse = NewsListResponse(ArrayList())
        assertNotNull(newsListResponse)
    }

    @Test
    fun testAttributes(){
        val newsItems = ArrayList<NewsItem>();
        newsItems.add(NewsItem(100L, "Test", "Test", "1-1-2019", "", ArrayList()))
        newsListResponse = NewsListResponse(newsItems)
        assertNotNull(newsListResponse)
        assertEquals(100L, newsListResponse?.popularNewsList?.get(0)?.id)
        assertEquals("Test", newsListResponse?.popularNewsList?.get(0)?.title)
        assertEquals("Test", newsListResponse?.popularNewsList?.get(0)?.authors)
        assertEquals("1-1-2019", newsListResponse?.popularNewsList?.get(0)?.publishedDate)
        assertNotNull(newsListResponse?.popularNewsList?.get(0)?.media)
    }
}