package com.bebetta.bebettaapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bebetta.bebettaapp.R
import com.bebetta.bebettaapp.databinding.GameCategoryItemBinding
import com.bebetta.bebettaapp.databinding.HappeningTickerItemBinding
import com.bebetta.bebettaapp.model.CategoryData
import com.bumptech.glide.Glide

/**
 * Created by Ritik on 2/6/2024.
 */
class TickerAdapter (
    private val context: Context,
    private val list: ArrayList<CategoryData>
) :
    RecyclerView.Adapter<TickerAdapter.ViewHolder>() {
    var selectedPosition = -1
    lateinit var binding: HappeningTickerItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = HappeningTickerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tickerName.text = item.title

        Glide.with(context)
            .load(item.icon)
            .into(holder.binding.tickerImage)


        if (position == selectedPosition) {
           binding.selected.visibility = View.VISIBLE
        } else {
            binding.selected.visibility = View.GONE
        }

        holder.binding.widgetItem.setOnClickListener {
                notifyItemChanged(selectedPosition)
            selectedPosition = position
            notifyItemChanged(selectedPosition)

        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: HappeningTickerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: HappeningTickerItemBinding

        init {
            this.binding = binding
        }
    }
}