package com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories

import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.domain.usecases.GetAllCategoriesUseCase
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.utils.CoroutineDispatchersProvider
import com.poklad.androidtestprojectny.utils.extensions.coRunCatching
import com.poklad.androidtestprojectny.utils.extensions.log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AllCategoriesViewModel @Inject constructor(
    coroutineDispatchersProvider: CoroutineDispatchersProvider,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) :
    BaseViewModel(coroutineDispatchersProvider) {
    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            log(throwable.message.toString())
        }
    private val _categoriesList = MutableStateFlow<List<Category>>(emptyList())
    val categoryList = _categoriesList.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        launchMain(withLoader = true) {
            fetchCategories(this)
        }
    }

    private suspend fun fetchCategories(scope: CoroutineScope) {
        scope.coRunCatching {
            withContext(dispatchers.getIO()) {
                getAllCategoriesUseCase.execute(Unit)
            }
        }.onSuccess { list ->
            _categoriesList.value = list
        }.onFailure { exception: Throwable ->
//            emitError(exception)
            log(exception.message.toString())
        }
    }
}