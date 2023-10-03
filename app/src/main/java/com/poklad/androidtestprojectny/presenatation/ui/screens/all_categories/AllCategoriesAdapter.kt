package com.poklad.androidtestprojectny.presenatation.ui.screens.all_categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.poklad.androidtestprojectny.databinding.ItemCategoryBinding
import com.poklad.androidtestprojectny.domain.model.Category
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseAdapter

class AllCategoriesAdapter : BaseAdapter<Category>() {
    private val differCallback = object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
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
        ), Binder<Category> {
        override fun bind(item: Category) {
            binding.apply {
                tvDisplayNameCategory.text = item.displayName
                tvPublishedDate.text = item.newestPublishedDate
            }
        }
    }
}