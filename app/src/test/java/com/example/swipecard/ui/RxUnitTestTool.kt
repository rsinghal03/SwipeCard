package com.example.swipecard.ui

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

class RxUnitTestTool {
    companion object {
        fun asyncToSync() {
            RxJavaPlugins.reset()
            RxAndroidPlugins.setInitMainThreadSchedulerHandler {Schedulers.trampoline()}
            RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
            RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        }
    }
}