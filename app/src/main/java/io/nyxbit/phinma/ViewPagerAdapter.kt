package io.nyxbit.phinma

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.nyxbit.phinma.databinding.ItemViewBinding

class ViewPagerAdapter(private val items: List<Int>, private val onClick: (Int) -> Unit) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private val infiniteItemCount: Int
        get() = if (items.isEmpty()) 0 else Int.MAX_VALUE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % items.size
        holder.bind(items[actualPosition], onClick)
    }

    override fun getItemCount(): Int = infiniteItemCount

    class ViewHolder(private val binding: ItemViewBinding, onClick: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int, onClick: (Int) -> Unit) {
            binding.imageView.setImageResource(item)
            binding.imageView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}
