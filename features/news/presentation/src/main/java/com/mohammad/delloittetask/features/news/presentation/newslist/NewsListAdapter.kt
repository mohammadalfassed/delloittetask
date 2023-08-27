package com.mohammad.delloittetask.features.news.presentation.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.delloittetask.features.news.domain.models.NewsListModel
import com.mohammad.delloittetask.features.news.presentation.databinding.ItemNewsBinding

/**
 * Project: Motory
 * Created: Aug 8, 2022
 *
 * @author Mohammad alfasid
 */
class NewsListAdapter(
    private var model: List<NewsListModel?>
) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>(), Filterable {

    var onNewsItemClick: ((newsListModel: NewsListModel?) -> Unit)? = null

    var modelFiltered: MutableList<NewsListModel?>? = mutableListOf()

    init {
        modelFiltered?.addAll(model)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListAdapter.ViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    fun getSizeList(): Int {
        return modelFiltered?.size ?: 0
    }

    override fun onBindViewHolder(holder: NewsListAdapter.ViewHolder, position: Int) {
        val model = modelFiltered?.get(position)
        holder.binding.model = model
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = modelFiltered?.size ?: 0

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position

    inner class ViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onNewsItemClick?.invoke(
                        modelFiltered?.get(position),
                    )
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (charSequence?.isNotEmpty() == true) {
                    filterResults.values = model.filter {
                        it?.title?.contains(charSequence, true) == true
                    }
                } else {
                    filterResults.values = model
                }
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                modelFiltered?.clear()
                modelFiltered?.addAll(filterResults.values as List<NewsListModel?>)
                notifyDataSetChanged()
            }
        }
    }

    interface OnClickSearchItemFieldListener {
        fun onClickItem(searchItem: NewsListModel?)
    }
}