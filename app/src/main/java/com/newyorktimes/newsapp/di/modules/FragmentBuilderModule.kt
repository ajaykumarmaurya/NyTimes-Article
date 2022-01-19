package com.newyorktimes.newsapp.di.modules

import com.newyorktimes.newsapp.view.fragment.news.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/****
 * The module which provides the android injection service to fragments.
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
@Suppress("unused")
@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeNewsListFragment(): NewsListFragment
}