package com.example.swipecard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swipecard.R
import com.example.swipecard.data.DataServiceProviderImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CardSwipePresetner().getListOfData()
    }
}
