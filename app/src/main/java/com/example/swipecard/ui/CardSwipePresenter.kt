package com.example.swipecard.ui

import com.example.swipecard.data.DataServiceProvider
import com.example.swipecard.data.model.Data
import com.example.swipecard.data.model.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class CardSwipePresenter(private val dataServiceProvider: DataServiceProvider) : CardSwipeContract.Presenter {

    override var view: CardSwipeContract.View? = null

    override var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getListOfData() {
        view?.showLoading()
        dataServiceProvider.getListOfData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { success -> handleSuccess(success) }
            .addTo(compositeDisposable)
    }

    private fun handleSuccess(success: Response?) {
        view?.hideLoading()
        success?.let { view?.showSwipeCard(it.data as ArrayList<Data>) }
    }
}