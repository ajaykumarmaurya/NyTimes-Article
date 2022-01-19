package com.newyorktimes.newsapp.di.components

import android.app.Application
import com.newyorktimes.newsapp.NYTimesApplication
import com.newyorktimes.newsapp.di.modules.ActivityBuilderModule
import com.newyorktimes.newsapp.di.modules.AppModule
import com.newyorktimes.newsapp.di.modules.NetworkModule
import com.newyorktimes.newsapp.di.modules.UrlModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/****
 * Application Component
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/12/22
 *****/
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        UrlModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(nyTimesApplication: NYTimesApplication)
}