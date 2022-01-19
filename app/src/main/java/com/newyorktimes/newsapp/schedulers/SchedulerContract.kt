package com.newyorktimes.newsapp.schedulers

import androidx.annotation.NonNull
import io.reactivex.Scheduler

/****
 * Scheduler contract interface
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
interface SchedulerContract {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}