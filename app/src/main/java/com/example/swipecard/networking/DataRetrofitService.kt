package com.example.swipecard.networking

import com.example.swipecard.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface DataRetrofitService {


    @GET(".")
    fun getListOfData(): Observable<Response>
}