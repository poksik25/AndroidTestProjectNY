package com.poklad.androidtestprojectny.presenatation.ui.screens.books_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.poklad.androidtestprojectny.NYApp
import com.poklad.androidtestprojectny.R
import com.poklad.androidtestprojectny.databinding.FragmemntBooksByCategoryBinding
import com.poklad.androidtestprojectny.presenatation.model.BookUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseFragment
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.presenatation.ui.screens.amazon_market.AmazonBuyFragment
import com.poklad.androidtestprojectny.utils.extensions.invisible
import com.poklad.androidtestprojectny.utils.extensions.showSnackbar
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
        goToAmazon()
    }

    private fun goToAmazon() {
        booksAdapter.setOnclickListener {
            val amazonUrl = it.amazonProductUrl
            navigateToFragment(
                R.id.action_booksByCategoryFragment_to_amazonBuyFragment,
                bundleOf(AmazonBuyFragment.LINK_AMAZON_ARG to amazonUrl)
            )
        }
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
                    binding.root.showSnackbar(
                        it?.message.toString(),
                        Snackbar.LENGTH_LONG
                    )
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
    }

    companion object {
        const val CATEGORY_ARG = "CATEGORY_ARG"
    }
}
