package com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories

import com.poklad.androidtestprojectny.domain.usecases.GetAllCategoriesUseCase
import com.poklad.androidtestprojectny.domain.usecases.InsertCategoriesUseCase
import com.poklad.androidtestprojectny.domain.usecases.ReadCategoriesUseCase
import com.poklad.androidtestprojectny.presenatation.mapper.CategoryToCategoryUiItemMapper
import com.poklad.androidtestprojectny.presenatation.model.CategoryUiItem
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
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val mapper: CategoryToCategoryUiItemMapper,
    private val readCategoriesUseCase: ReadCategoriesUseCase,
    private val insertCategoriesUseCase: InsertCategoriesUseCase
) :
    BaseViewModel(coroutineDispatchersProvider) {
    override val coroutineExceptionHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            log(throwable.message.toString())
        }
    private val _categoriesList = MutableStateFlow<List<CategoryUiItem>>(emptyList())
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
                getAllCategoriesUseCase.execute(Unit).map(mapper::map)
            }
        }.onSuccess { list ->
            _categoriesList.value = list
        }.onFailure { exception: Throwable ->
            emitError(exception)
        }
    }
}