package com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.poklad.androidtestprojectny.databinding.ItemCategoryBinding
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.presenatation.model.CategoryUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseAdapter

class AllCategoriesAdapter : BaseAdapter<CategoryUiItem>() {
    private val differCallback = object : DiffUtil.ItemCallback<CategoryUiItem>() {
        override fun areItemsTheSame(
            oldItem: CategoryUiItem,
            newItem: CategoryUiItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryUiItem,
            newItem: CategoryUiItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    override val differList = AsyncListDiffer(this, differCallback)
    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    inner class CategoriesViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ), Binder<CategoryUiItem> {
        override fun bind(item: CategoryUiItem) {
            binding.apply {
                tvDisplayNameCategory.text = item.displayName
                tvPublishedDate.text = item.newestPublishedDate
            }
        }
    }
}