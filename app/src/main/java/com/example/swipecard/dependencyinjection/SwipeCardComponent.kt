package com.example.swipecard.dependencyinjection

import com.example.swipecard.ui.MainActivity
import dagger.Component

@Component(modules = [SwipeCardModule::class])
interface SwipeCardComponent {

    fun inject(mainActivity: MainActivity)
}