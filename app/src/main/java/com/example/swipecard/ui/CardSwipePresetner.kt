package com.example.swipecard.ui

import com.example.swipecard.data.DataServiceProviderImpl
import com.example.swipecard.data.model.Data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CardSwipePresetner {

    fun getListOfData() {
        val disposable = DataServiceProviderImpl().getListOfData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { success -> handleSuccess(success) }
    }

    private fun handleSuccess(success: Data?) {

    }
}