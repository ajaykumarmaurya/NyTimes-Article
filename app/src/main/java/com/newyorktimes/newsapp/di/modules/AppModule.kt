package com.newyorktimes.newsapp.di.modules

import com.newyorktimes.newsapp.data.remote.Api
import com.newyorktimes.newsapp.repository.NewsRepository
import com.newyorktimes.newsapp.schedulers.SchedulerContract
import com.newyorktimes.newsapp.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/****
 * Application Module which is responsible for providing the app wide instances.
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
@Module(includes = [(ViewModelModule::class)])
class AppModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit) : Api {
        return retrofit.create(Api::class.java)
    }


    @Provides
    @Singleton
    fun provideUserkRepository(api: Api, scheduler: SchedulerContract): NewsRepository {
        return NewsRepository(api, scheduler)
    }

    @Provides
    @Singleton
    fun provideScheduler(): SchedulerContract {
        return SchedulerProvider()
    }
}