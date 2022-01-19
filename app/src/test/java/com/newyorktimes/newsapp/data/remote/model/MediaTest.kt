package com.newyorktimes.newsapp.data.remote.model

import org.junit.Test
import org.junit.Assert.*

/****
 * Unit test for Media Model class
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class MediaTest {

    var metaDataList : ArrayList<MediaMetadata>? = null
    var media: Media? = null



    @Test
    fun testMediaObjectNull(){
        assertNull(metaDataList)
        assertNull(media)
    }

    @Test
    fun testMediaObjectNonNull(){
        metaDataList = ArrayList()
        media = Media(metaDataList!!)
        assertNotNull(metaDataList)
        assertNotNull(media)
    }

}