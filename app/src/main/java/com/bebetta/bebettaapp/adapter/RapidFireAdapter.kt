package com.bebetta.bebettaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bebetta.bebettaapp.databinding.QuizItemBinding

/**
 * Created by Ritik on 2/7/2024.
 */
class RapidFireAdapter (
    private val context: Context,
    private val list: ArrayList<String>
) : RecyclerView.Adapter<RapidFireAdapter.ViewHolder>() {
    lateinit var binding: QuizItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = QuizItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(binding: QuizItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: QuizItemBinding

        init {
            this.binding = binding
        }
    }
}