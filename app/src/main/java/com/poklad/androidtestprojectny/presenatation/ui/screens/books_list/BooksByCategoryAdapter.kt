package com.poklad.androidtestprojectny.presenatation.ui.screens.books_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poklad.androidtestprojectny.databinding.ItemBookBinding
import com.poklad.androidtestprojectny.presenatation.model.BookUiItem
import com.poklad.androidtestprojectny.presenatation.ui.base.BaseAdapter
import com.poklad.androidtestprojectny.utils.extensions.loadImage

class BooksByCategoryAdapter : BaseAdapter<BookUiItem>() {

    private val differCallback = object : DiffUtil.ItemCallback<BookUiItem>() {
        override fun areItemsTheSame(
            oldItem: BookUiItem,
            newItem: BookUiItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BookUiItem,
            newItem: BookUiItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    override val differList = AsyncListDiffer(this, differCallback)
    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksHolder(binding)
    }

    inner class BooksHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ), Binder<BookUiItem> {
        override fun bind(item: BookUiItem) {
            binding.apply {
                tvAuthor.text = item.author
                tvDescription.text = item.description
                tvPublisher.text = item.publisher
                tvTitle.text = item.title
                tvRankDigit.text = item.rank.toString()
                ivBookImage.loadImage(item.bookImage)
                fbBuy.setOnClickListener {
                    onItemClickListener?.let { it(item) }
                }
            }
        }
    }
}