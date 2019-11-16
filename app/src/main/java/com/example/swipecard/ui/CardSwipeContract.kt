package com.example.swipecard.ui

import android.view.View
import com.example.swipecard.BaseContract
import com.example.swipecard.data.model.Data

interface CardSwipeContract {

    interface View: BaseContract.BaseView {
        fun showSwipeCard(listOfData: ArrayList<Data>)
    }

    interface Presenter : BaseContract.BasePresenter<View> {
        fun getListOfData()
    }



}