package io.nyxbit.phinma

import androidx.recyclerview.widget.RecyclerView
import io.nyxbit.phinma.databinding.ItemCourseBinding

class CourseViewHolder(val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.title.text = "‣  ${data.title}"

    }
}
