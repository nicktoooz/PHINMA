package io.nyxbit.phinma

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import io.nyxbit.phinma.databinding.ItemCourseBinding


class CourseRecyclerAdapter(
    private val dataSet: MutableList<Data>,
    private val viewModel : ViewModel
) : RecyclerView.Adapter<CourseViewHolder>() {

    private var expandedPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.title.setBackgroundColor(Color.parseColor(viewModel.school.primaryColor))

        val data = dataSet[position]
        holder.bind(data)

        if (position == expandedPosition) {
            holder.binding.description.text = data.description
            holder.binding.description.visibility = View.VISIBLE
            val customFont = ResourcesCompat.getFont(holder.itemView.context, R.font.optima_medium)
            holder.binding.title.typeface = customFont
            holder.binding.title.setTypeface(customFont, Typeface.BOLD)
            holder.binding.title.textSize = 20f


        } else {
            holder.binding.description.visibility = View.GONE
            val customFont = ResourcesCompat.getFont(holder.itemView.context, R.font.optima_medium)
            holder.binding.title.typeface = customFont
            holder.binding.title.setTypeface(customFont, Typeface.NORMAL)
            holder.binding.title.textSize = 14f
        }

        // Set the click listener to expand/collapse items
        holder.itemView.setOnClickListener {
            // If the clicked item is not the currently expanded one
            if (expandedPosition != position) {
                val prevExpandedPosition = expandedPosition
                expandedPosition = position
                notifyItemChanged(prevExpandedPosition ?: -1)
                notifyItemChanged(position)
            } else {
                // Collapse the current item
                expandedPosition = null
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount() = dataSet.size
}
