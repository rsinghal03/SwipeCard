package com.example.swipecard.data

import com.example.swipecard.data.model.Data
import com.example.swipecard.networking.DataRetrofitService
import com.example.swipecard.networking.RetrofitApiClient
import io.reactivex.Observable

class DataServiceProviderImpl : DataServiceProvider {
    override fun getListOfData(): Observable<Data> {
        val retrofitService = RetrofitApiClient().getRetrofit().create(DataRetrofitService::class.java)
        return retrofitService.getListOfData()
    }
}