package io.nyxbit.phinma

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import io.nyxbit.phinma.databinding.FragmentCalendarBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Locale

class FragmentCalendar : Fragment() {

    private lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )
            : View {

        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        val event = mutableListOf(
            "2024-11-06", // English Fest
            "2024-11-07", // Tourism Day
            "2024-11-08", // Testimonial and CEA Mustahan/Builders' Assembly
            "2024-12-05", // Lamparaan
            "2024-12-09", // Ninging Project
            "2024-12-12", // Lingapvika Community Outreach Program
            "2025-01-03", // Eucharistic Celebration
            "2025-01-09", // Strand Day
            "2025-01-14", // Seminar for the DSPC Participants
            "2025-01-07", // Tree Planting
            "2025-01-17"  // Seminar Caltech/Safety Training
        )

        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)

        updateMonthTitle(currentMonth)

        binding.calendarView.setup(firstMonth, lastMonth, DayOfWeek.SUNDAY)
        binding.calendarView.scrollToMonth(currentMonth)

        binding.calendarView.monthScrollListener = { month ->
            updateMonthTitle(month.yearMonth)
            Log.d("TAG", month.toString())
        }

        binding.calendarView.dayBinder = object : MonthDayBinder<DayViewContainer> {
            override fun create(view: View): DayViewContainer {
                return DayViewContainer(view)
            }

            override fun bind(container: DayViewContainer, data: CalendarDay) {
                container.textView.text = data.date.dayOfMonth.toString()
                container.view.setOnClickListener {
                    if (event.contains(data.date.toString())) {
                        viewModel.date = data.date.toString()
                        findNavController().navigate(R.id.action_fragmentCalendar_to_event)
                    }
                }
                val specificDate = LocalDate.parse(data.date.toString())
                val dayOfWeek: DayOfWeek = specificDate.dayOfWeek

                if (event.contains(data.date.toString())) {
                    container.label.visibility = View.VISIBLE
                    container.view.setBackgroundColor(
                        Color.parseColor(
                            "#33${
                                viewModel.school.primaryColor.removePrefix(
                                    "#"
                                )
                            }"
                        )
                    )
                    container.label.backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor(viewModel.school.primaryColor))
                } else {
                    container.label.visibility = View.INVISIBLE
                    container.view.setBackgroundColor(Color.TRANSPARENT)
                }

                if (data.position == DayPosition.MonthDate) {
                    container.textView.setTextColor(Color.BLACK)
                } else {
                    container.textView.setTextColor(Color.GRAY)
                }
                if (data.date == LocalDate.now()) {
                    container.textView.setTextColor(Color.RED)
                }

                if (dayOfWeek == DayOfWeek.SUNDAY) {
                    container.textView.setTextColor(Color.RED)
                }

            }
        }

        return binding.root
    }

    private fun updateMonthTitle(yearMonth: YearMonth) {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.getDefault())
        val monthTitle = yearMonth.format(formatter)
        binding.monthName.text = monthTitle
    }

    class DayViewContainer(view: View) : ViewContainer(view) {
        val textView: TextView = view.findViewById(R.id.calendarDayText)
        val label: View = view.findViewById(R.id.label)
    }
}
