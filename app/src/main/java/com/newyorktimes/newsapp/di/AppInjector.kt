package com.newyorktimes.newsapp.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.newyorktimes.newsapp.NYTimesApplication
import com.newyorktimes.newsapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector


/****
 * Helper class to automatically inject fragments if they implement [Injectable].
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
object AppInjector {
    fun init(nyTimesApplication: NYTimesApplication) {
        DaggerAppComponent.builder().application(nyTimesApplication)
            .build().inject(nyTimesApplication)
        nyTimesApplication.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivityResumed(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivityPaused(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivityStopped(activity: Activity) {
                // Nothing goes here
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                // Nothing goes here

            }


            override fun onActivityDestroyed(activity: Activity) {
                // Nothing goes here
            }
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is androidx.fragment.app.FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                            fm: androidx.fragment.app.FragmentManager,
                            f: androidx.fragment.app.Fragment,
                            savedInstanceState: Bundle?
                        ) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true
                )
        }
    }
}