package com.example.swipecard.ui

import android.view.View
import com.example.swipecard.BaseContract

interface CardSwipeContract {

    interface View: BaseContract.BaseView {

    }

    interface Presenter : BaseContract.BasePresenter<View> {
        fun getListOfData()
    }



}