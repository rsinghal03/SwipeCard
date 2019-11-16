package com.example.swipecard.dependencyinjection

import com.example.swipecard.data.DataServiceProvider
import com.example.swipecard.data.DataServiceProviderImpl
import com.example.swipecard.networking.RetrofitApiClient
import com.example.swipecard.ui.CardSwipeContract
import com.example.swipecard.ui.CardSwipePresenter
import dagger.Module
import dagger.Provides

@Module
class SwipeCardModule {

    @Provides
    fun provideCardSwipePresenter(dataServiceProvider: DataServiceProvider): CardSwipeContract.Presenter {
        return CardSwipePresenter(dataServiceProvider)
    }

    @Provides
    fun provideDataServiceProvider(retrofitApiClient: RetrofitApiClient): DataServiceProvider {
        return DataServiceProviderImpl(retrofitApiClient)
    }

    @Provides
    fun provideRetrofitApiClient(): RetrofitApiClient {
        return RetrofitApiClient()
    }
}