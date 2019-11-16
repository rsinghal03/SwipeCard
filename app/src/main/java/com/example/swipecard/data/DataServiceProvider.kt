package com.example.swipecard.data

import com.example.swipecard.data.model.Response
import io.reactivex.Observable

interface DataServiceProvider {

    fun getListOfData(): Observable<Response>

}