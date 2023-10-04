package com.poklad.androidtestprojectny.presenatation.ui.screens.amazon_market

import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.utils.CoroutineDispatchersProvider
import com.poklad.androidtestprojectny.utils.extensions.log
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

class AmazonBuyViewModel @Inject constructor(coroutineDispatchersProvider: CoroutineDispatchersProvider) :
    BaseViewModel(coroutineDispatchersProvider) {
    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            log(throwable.message.toString())
        }
}