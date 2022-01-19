package com.newyorktimes.newsapp.data.remote.model

import org.junit.Test
import org.junit.Assert.*

/****
 * Unit test for Media Metadata
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
class MediaMetadataTest {

    var metadataObject: MediaMetadata? = null

    @Test
    fun testNullObject(){
        assertNull(metadataObject)
    }

    @Test
    fun testNonNullObject(){
        metadataObject = MediaMetadata("", "")
        assertNotNull(metadataObject)
    }

    @Test
    fun testProperties(){
        metadataObject = MediaMetadata("", "")
        assertNotNull(metadataObject)
        assertEquals("", metadataObject?.imageUrl)
        assertEquals("", metadataObject?.format)

        val metadataObject2 = MediaMetadata("http://www.google.com", "png")
        assertNotNull(metadataObject2)
        assertEquals("http://www.google.com", metadataObject2.imageUrl)
        assertEquals("png", metadataObject2.format)
    }
}