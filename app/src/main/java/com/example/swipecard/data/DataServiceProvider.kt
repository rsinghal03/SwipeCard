package com.example.swipecard.data

import com.example.swipecard.data.model.Data
import io.reactivex.Observable

interface DataServiceProvider {

    fun getListOfData(): Observable<Data>

}