package com.bebetta.bebettaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bebetta.bebettaapp.databinding.ScoreItemBinding
import com.bebetta.bebettaapp.model.ScoreData
import com.bumptech.glide.Glide

/**
 * Created by Ritik on 2/6/2024.
 */
class ScoreAdapter  (
    private val context: Context,
    private val list: ArrayList<ScoreData>
) : RecyclerView.Adapter<ScoreAdapter.ViewHolder>() {
    lateinit var binding: ScoreItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ScoreItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.countryName.text = item.cur_country
        holder.binding.opCountryName.text = item.op_country
        holder.binding.time.text = item.time

        Glide.with(context)
            .load(item.cur_image)
            .into(holder.binding.countryImage)

        Glide.with(context)
            .load(item.op_image)
            .into(holder.binding.opCountryImage)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: ScoreItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: ScoreItemBinding

        init {
            this.binding = binding
        }
    }
}