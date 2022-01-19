package com.newyorktimes.newsapp.repository

import com.newyorktimes.newsapp.data.remote.response.ApiResponse
import com.newyorktimes.newsapp.data.remote.response.ResponseListener
import com.newyorktimes.newsapp.data.remote.response.ResponseStatus
import com.newyorktimes.newsapp.schedulers.SchedulerContract
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/****
 * Base repository which is responsible for executing all the REST service calls
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
open class BaseRepository (val scheduler: SchedulerContract){


    /**
     * This method perfroms the asynchronous network request using the scheduler
     * @param observable : Observable network request
     * @param responseListener: ResponseListener Callback
     */
     fun <T : Any> performRequest(observable: Observable<T>, responseListener: ResponseListener<T>) : Disposable {
        return observable.subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe { responseListener.onStart() }
            .doAfterTerminate { responseListener.onFinish() }
            .subscribe({ result: T -> responseListener.onResponse(ApiResponse(ResponseStatus.SUCCESS, result, null)) },
                { error: Throwable? -> responseListener.onResponse(ApiResponse(ResponseStatus.FAILURE, null, error)) })

    }

}