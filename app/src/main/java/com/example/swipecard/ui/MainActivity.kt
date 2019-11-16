package com.example.swipecard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.swipecard.R
import com.example.swipecard.SwipeCardApplication
import com.example.swipecard.data.model.Data
import com.example.swipecard.extension.gone
import com.example.swipecard.extension.visible
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.progress_bar.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), CardSwipeContract.View, SwipeFlingAdapterView.onFlingListener, SwipeFlingAdapterView.OnItemClickListener {

    @Inject
    lateinit var presenter: CardSwipeContract.Presenter

    private lateinit var arrayAdapter: ArrayAdapter<Data>

    private val mOriginalListOfData: ArrayList<Data> = ArrayList()

    private var originalSizeOfList: Int = 0

    private val mNewListOfData: ArrayList<Data> = ArrayList()

    private var mPointer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SwipeCardApplication.getInstance().component.inject(this)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        presenter.getListOfData()
    }

    override fun showSwipeCard(listOfData: ArrayList<Data>) {
        mOriginalListOfData.addAll(listOfData)
        mNewListOfData.addAll(listOfData)
        originalSizeOfList = mOriginalListOfData.size
        swipeFlingAdapterView.visible()
        progressCount.visible()
        setProgressText(mPointer+1)
        arrayAdapter = ArrayAdapter(this, R.layout.swipe_item, R.id.helloText, mNewListOfData)
        swipeFlingAdapterView.init(this, arrayAdapter)
    }

    override fun removeFirstObjectInAdapter() {
//        mOriginalListOfData.removeAt(0)
//        arrayAdapter.notifyDataSetChanged()
    }

    override fun onLeftCardExit(p0: Any?) {
        if(mPointer > 0){
            setProgressText(mPointer)
            mPointer -= 1
        }
        setNewListOfData()
//        Toast.makeText(this, "onLeftPrevious", Toast.LENGTH_SHORT).show()

    }

    override fun onRightCardExit(p0: Any?) {
        if(mPointer < originalSizeOfList-1){
            mPointer += 1
            setProgressText(mPointer+1)
        }
        setNewListOfData()
//        Toast.makeText(this, "onRightNext", Toast.LENGTH_LONG).show()

    }

    override fun onAdapterAboutToEmpty(p0: Int) {
//        Toast.makeText(this, "aboutTOEmpty", Toast.LENGTH_LONG).show()
    }

    override fun onScroll(p0: Float) {
//        Toast.makeText(this, "onScroll", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(p0: Int, p1: Any?) {

    }

    private fun setProgressText(count: Int) {
        val progressText = "$count/$originalSizeOfList"
        progressCount.text = progressText
    }

    private fun setNewListOfData() {
        mNewListOfData.clear()
        var i = mPointer
        val size = mOriginalListOfData.size
        while (i < size) {
            mNewListOfData.add(mOriginalListOfData[i])
            i++
        }
        arrayAdapter.notifyDataSetChanged()
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
