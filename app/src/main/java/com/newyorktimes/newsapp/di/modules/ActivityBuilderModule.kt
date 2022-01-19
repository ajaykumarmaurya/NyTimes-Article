package com.newyorktimes.newsapp.di.modules

import com.newyorktimes.newsapp.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/****
 * The module which provides the android injection service to activities
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
@Suppress("unused")
@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}