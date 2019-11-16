package com.example.swipecard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swipecard.R
import com.example.swipecard.SwipeCardApplication
import com.example.swipecard.data.model.Data
import com.example.swipecard.extension.gone
import com.example.swipecard.extension.visible
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), CardSwipeContract.View {

    @Inject
    lateinit var presenter: CardSwipeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SwipeCardApplication.getInstance().component.inject(this)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        presenter.getListOfData()
    }

    override fun showSwipeCard(listOfData: ArrayList<Data>) {
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showLoading() {
        progress_bar_id.visible()
    }

    override fun hideLoading() {
        progress_bar_id.gone()
    }

}
