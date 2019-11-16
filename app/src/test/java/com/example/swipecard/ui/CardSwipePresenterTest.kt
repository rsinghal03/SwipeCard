package com.example.swipecard.ui

import com.example.swipecard.MockDataProvider
import com.example.swipecard.data.DataServiceProvider
import com.example.swipecard.data.model.Data
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CardSwipePresenterTest {


    lateinit var cardSwipePresenter: CardSwipePresenter

    @Mock
    lateinit var dataServiceProvider: DataServiceProvider

    @Mock
    lateinit var view: CardSwipeContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxUnitTestTool.asyncToSync()
        cardSwipePresenter = CardSwipePresenter(dataServiceProvider)
        cardSwipePresenter.attachView(view)
    }

    @After
    fun tearDown() {
        cardSwipePresenter.detachView()
    }

    @Test
    fun getListOfDataSuccessTest() {
        val listOfData = MockDataProvider.getListOfData()
        Mockito.`when`(dataServiceProvider.getListOfData())
            .thenReturn(Observable.just(MockDataProvider.getListOfDataSuccessResponse()))
        cardSwipePresenter.getListOfData()
        Mockito.verify(view).showLoading()
        Mockito.verify(dataServiceProvider).getListOfData()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showSwipeCard(listOfData as ArrayList<Data>)
    }
}