package com.bebetta.bebettaapp.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bebetta.bebettaapp.R
import com.bebetta.bebettaapp.databinding.AddingSoonItemBinding
import com.bebetta.bebettaapp.databinding.GameCategoryItemBinding
import com.bebetta.bebettaapp.model.CategoryData
import com.bumptech.glide.Glide

/**
 * Created by Ritik on 2/6/2024.
 */
class GameCategoryAdapter(private val context: Context, private val list: List<CategoryData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_COMING_SOON = 1
    var selectedPosition = -1
    lateinit var gameBinding: GameCategoryItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            val binding = GameCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ItemViewHolder(binding)
        } else {
            val binding = AddingSoonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AddingSoonViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            val itemHolder = holder as ItemViewHolder
            val item = list[position]
        holder.binding.gameName.text = item.title

        Glide.with(context)
            .load(item.icon)
            .into(holder.binding.gameIcon)

            if (position == selectedPosition) {
                holder.binding.widget.setBackgroundResource(R.drawable.selected_gradient)
                holder.binding.gameName.setTextColor(Color.BLACK)
                holder.binding.gameIcon.setColorFilter(Color.parseColor("#FF7300"))
            } else {
                holder.binding.widget.setBackgroundResource(R.drawable.unselected)
                holder.binding.gameName.setTextColor(Color.WHITE)
                holder.binding.gameIcon.setColorFilter(Color.WHITE)
            }


            holder.binding.widget.setOnClickListener {
                if (selectedPosition >= 0) {
                    notifyItemChanged(selectedPosition)
                }
                selectedPosition = position
                notifyItemChanged(selectedPosition)

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) {
            VIEW_TYPE_COMING_SOON
        } else {
            VIEW_TYPE_ITEM
        }
    }

    inner class ItemViewHolder(gameBinding: GameCategoryItemBinding) : RecyclerView.ViewHolder(gameBinding.root) {
        var binding: GameCategoryItemBinding
        init {
            this.binding = gameBinding
        }
    }

    inner class AddingSoonViewHolder(private val binding: AddingSoonItemBinding) : RecyclerView.ViewHolder(binding.root)
}
