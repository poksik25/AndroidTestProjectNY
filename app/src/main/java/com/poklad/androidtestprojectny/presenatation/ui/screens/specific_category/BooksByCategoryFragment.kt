package com.poklad.androidtestprojectny.presenatation.ui.screens.specific_category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.poklad.androidtestprojectny.NYApp
import com.poklad.androidtestprojectny.databinding.FragmemntBooksByCategoryBinding
import com.poklad.androidtestprojectny.di.component.DaggerAppComponent
import com.poklad.androidtestprojectny.presenatation.model.BookUiItem
import com.poklad.androidtestprojectny.presenatation.model.CategoryUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseFragment
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories.AllCategoriesAdapter
import com.poklad.androidtestprojectny.utils.extensions.invisible
import com.poklad.androidtestprojectny.utils.extensions.toast
import com.poklad.androidtestprojectny.utils.extensions.visible
import kotlinx.coroutines.launch
import javax.inject.Inject

class BooksByCategoryFragment : BaseFragment<FragmemntBooksByCategoryBinding, BaseViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: BooksByCategoryViewModel by viewModels {
        viewModelFactory
    }

    override fun inflateViewBinding(inflater: LayoutInflater): FragmemntBooksByCategoryBinding =
        FragmemntBooksByCategoryBinding.inflate(inflater)

    private val booksAdapter: BooksByCategoryAdapter by lazy {
        BooksByCategoryAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NYApp.daggerAppComponent.inject(this@BooksByCategoryFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCategoryName()
        setUpObserver()
        initRecyclerView()
    }

    private fun getCategoryName() {
        val categoryName = requireArguments().getString(CATEGORY_ARG)
        categoryName?.let { viewModel.loadBooks(it) }
    }

    private fun setUpObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadingFlow.collect { showLoader ->
                    if (showLoader) {
                        binding.apply {
                            pbBooks.visible()
                            rvBooksList.invisible()
                        }
                    } else {
                        binding.apply {
                            pbBooks.invisible()
                            rvBooksList.visible()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.bookList.collect { list ->
                renderList(list)
            }
        }
        setUpErrorHandling()
    }

    private fun setUpErrorHandling() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.errorFlow.collect {
                    requireContext().toast(it?.message.toString())
                }
            }
        }
    }

    private fun renderList(categoryList: List<BookUiItem>) {
        booksAdapter.list = categoryList
    }

    private fun initRecyclerView() {
        binding.rvBooksList.apply {
            adapter = booksAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        booksAdapter.setOnclickListener { category ->
            requireContext().toast(category.amazonProductUrl)
        }
    }

    companion object {
        const val CATEGORY_ARG = "CATEGORY_ARG"
    }
}
