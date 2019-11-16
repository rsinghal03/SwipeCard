package com.example.swipecard

import android.app.Application
import com.example.swipecard.dependencyinjection.DaggerSwipeCardComponent
import com.example.swipecard.dependencyinjection.SwipeCardComponent

class SwipeCardApplication : Application() {

    lateinit var component: SwipeCardComponent

    init {
        initDagger()
    }

    private fun initDagger() {
        component = DaggerSwipeCardComponent.create()
    }

    companion object {

        private var instance: SwipeCardApplication? = null

        fun getInstance(): SwipeCardApplication =
            instance ?: SwipeCardApplication().also {
                instance = it
            }
    }
}