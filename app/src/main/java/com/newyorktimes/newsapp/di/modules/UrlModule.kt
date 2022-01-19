package com.newyorktimes.newsapp.di.modules

import com.newyorktimes.newsapp.common.Configuration
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/****
 * Url Module
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
@Module
class UrlModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return Configuration.baseURL
    }
}