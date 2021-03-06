package com.newyorktimes.newsapp.di.modules

import com.newyorktimes.newsapp.common.Configuration
import com.newyorktimes.newsapp.data.remote.RequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/****
 * Network Module which provides the retrofit related instances
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/

@Module
class NetworkModule {
    private val CONNECTION_TIMEOUT: Long = 30000
    private val READ_TIMEOUT: Long = 30000
    private val WRITE_TIMEOUT: Long = 3000

    companion object {
        private const val BASE_URL = "baseUrl"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        val cookieHandler = CookieManager()
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(RequestInterceptor())
            .cookieJar(JavaNetCookieJar(cookieHandler))
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(@Named(BASE_URL) baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}