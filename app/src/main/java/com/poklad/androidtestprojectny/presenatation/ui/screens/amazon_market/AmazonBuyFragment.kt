package com.poklad.androidtestprojectny.presenatation.ui.screens.amazon_market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poklad.androidtestprojectny.R
import com.poklad.androidtestprojectny.databinding.FragmentAmazonBinding
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseFragment
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseViewModel
import com.poklad.androidtestprojectny.presenatation.ui.screens.books_list.BooksByCategoryViewModel
import com.poklad.androidtestprojectny.utils.delegate.viewBinding
import javax.inject.Inject

class AmazonBuyFragment : Fragment(R.layout.fragment_amazon) {
    private val binding: FragmentAmazonBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = requireArguments().getString(LINK_AMAZON_ARG)
        binding.webViewAmazon.apply {
            webViewClient = WebViewClient()
            url?.let {
                loadUrl(it)
            }
        }
    }

    companion object {
        const val LINK_AMAZON_ARG = "amazon"
    }
}