package com.bebetta.bebettaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bebetta.bebettaapp.databinding.MatchPreviewItemBinding
import com.bebetta.bebettaapp.model.CategoryData
import com.bumptech.glide.Glide

/**
 * Created by Ritik on 2/7/2024.
 */
class LiveAdapter(
    private val context: Context,
    private val list: ArrayList<CategoryData>
) : RecyclerView.Adapter<LiveAdapter.ViewHolder>() {
    lateinit var binding: MatchPreviewItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = MatchPreviewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        binding.time.text = item.title

        Glide.with(context)
            .load(item.icon)
            .into(holder.binding.thumbnail)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: MatchPreviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: MatchPreviewItemBinding

        init {
            this.binding = binding
        }
    }
}