package io.nyxbit.phinma

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.nyxbit.phinma.databinding.HandbookPagerItemBinding

class HandbookPagerAdapter(private val items: List<Pair<String,String>>) : RecyclerView.Adapter<HandbookPagerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HandbookPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: HandbookPagerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<String, String>) {
            binding.title.text = item.first
            binding.description.text = item.second
        }


    }
}
