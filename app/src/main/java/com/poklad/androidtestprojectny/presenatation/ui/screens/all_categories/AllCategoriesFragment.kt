package com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories

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
import com.poklad.androidtestprojectny.NYApp
import com.poklad.androidtestprojectny.R
import com.poklad.androidtestprojectny.databinding.FragmentAllCategoriesBinding
import com.poklad.androidtestprojectny.presenatation.model.CategoryUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseFragment
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.presenatation.ui.screens.books_list.BooksByCategoryFragment
import com.poklad.androidtestprojectny.utils.delegate.viewBinding
import com.poklad.androidtestprojectny.utils.extensions.invisible
import com.poklad.androidtestprojectny.utils.extensions.showSnackbar
import com.poklad.androidtestprojectny.utils.extensions.visible
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllCategoriesFragment : BaseFragment<FragmentAllCategoriesBinding, BaseViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: AllCategoriesViewModel by viewModels {
        viewModelFactory
    }

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentAllCategoriesBinding =
        FragmentAllCategoriesBinding.inflate(inflater)

    private val allCategoriesAdapter: AllCategoriesAdapter by lazy {
        AllCategoriesAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        NYApp.daggerAppComponent.inject(this@AllCategoriesFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        initRecyclerView()
    }

    private fun setUpObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadingFlow.collect { showLoader ->
                    if (showLoader) {
                        binding.apply {
                            pbCategories.visible()
                            rvCategoriesList.invisible()
                        }
                    } else {
                        binding.apply {
                            pbCategories.invisible()
                            rvCategoriesList.visible()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categoryList.collect { list ->
                renderList(list)
            }
        }
        setUpErrorHandling()
    }

    private fun setUpErrorHandling() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.errorFlow.collect {
                    binding.root.showSnackbar(it?.message.toString())
                }
            }
        }
    }

    private fun renderList(categoryList: List<CategoryUiItem>) {
        allCategoriesAdapter.list = categoryList
    }

    private fun initRecyclerView() {
        binding.rvCategoriesList.apply {
            adapter = allCategoriesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        allCategoriesAdapter.setOnclickListener { category ->
            val categoryName = category.listNameEncoded
            navigateToFragment(
                R.id.action_allCategoriesFragment_to_booksByCategoryFragment,
                bundleOf(BooksByCategoryFragment.CATEGORY_ARG to categoryName)
            )
        }
    }
}
