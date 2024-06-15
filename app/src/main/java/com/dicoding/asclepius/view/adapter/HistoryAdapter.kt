package com.dicoding.asclepius.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.asclepius.databinding.HistoryItemsBinding
import com.dicoding.asclepius.model.CancerEntity

class HistoryAdapter(private val history: List<CancerEntity>) :
    RecyclerView.Adapter<HistoryAdapter.historyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): historyViewHolder {
        return historyViewHolder( HistoryItemsBinding.inflate( LayoutInflater.from(parent.context), parent, false ))
    }

    override fun getItemCount(): Int = history.size

    override fun onBindViewHolder(holder: historyViewHolder, position: Int) {
        holder.binding.predict.text = history[position].prediction
        holder.binding.confidence.text = history[position].confidenceScore.toString()
    }

    class historyViewHolder(val binding: HistoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}