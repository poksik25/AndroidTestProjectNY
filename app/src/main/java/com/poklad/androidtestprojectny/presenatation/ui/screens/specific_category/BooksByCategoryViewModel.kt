package com.poklad.androidtestprojectny.presenatation.ui.screens.specific_category

import com.poklad.androidtestprojectny.domain.usecases.GetBooksByCategoryUseCase
import com.poklad.androidtestprojectny.presenatation.mapper.BookToBookItemUiMapper
import com.poklad.androidtestprojectny.presenatation.model.BookUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.utils.CoroutineDispatchersProvider
import com.poklad.androidtestprojectny.utils.extensions.coRunCatching
import com.poklad.androidtestprojectny.utils.extensions.log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class BooksByCategoryViewModel @Inject constructor(
    coroutineDispatchersProvider: CoroutineDispatchersProvider,
    private val getBooks: GetBooksByCategoryUseCase,
    private val mapper: BookToBookItemUiMapper
) : BaseViewModel(coroutineDispatchersProvider) {
    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            log(throwable.message.toString())
        }
    private val _booksList = MutableStateFlow<List<BookUiItem>>(emptyList())
    val bookList = _booksList.asStateFlow()

    fun loadBooks(category: String) {
        launchMain(withLoader = true) {
            fetchBooks(this, category)
        }
    }

    private suspend fun fetchBooks(coroutineScope: CoroutineScope, category: String) {
        coroutineScope.coRunCatching {
            getBooks.execute(category)
        }.onSuccess { books ->
            _booksList.value = books.map(mapper::map)
        }.onFailure { exception: Throwable ->
            emitError(exception)
        }
    }
}