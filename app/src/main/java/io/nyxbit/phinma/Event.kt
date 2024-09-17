package io.nyxbit.phinma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.nyxbit.phinma.databinding.FragmentEventBinding


class Event : Fragment() {

    private lateinit var binding: FragmentEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        val eventMap = mutableMapOf(
            "2024-11-06" to Pair(
                "English Fest",
                "Join us for the English Fest on November 6 at the CB Mall Events Center! This day is dedicated to celebrating English language and literature through a variety of exciting activities, including speeches, debates, and creative performances. It’s a wonderful opportunity to showcase your skills, enjoy literary games, and engage in enriching discussions. Don't miss out on this day of language and fun!"
            ),
            "2024-11-07" to Pair(
                "Tourism Day",
                "Experience Tourism Day on November 7, hosted by the International School of Tourism Management at the UPang U Atrium! This event highlights the rich and diverse cultures and travel destinations from around the world. Through presentations, exhibits, and interactive activities, you’ll get to learn more about global tourism and explore different cultures. It’s a fantastic chance to broaden your horizons and engage with the world’s wonders!"
            ),
            "2024-11-08" to Pair(
                "Testimonial and CEA Mustahan/Builders' Assembly",
                "Don't miss the Testimonial and Builders' Assembly on November 8, organized by the Philippine Institute of Civil Engineers, Inc. - PUPU Chapter at the UPang U Atrium. It's a chance to hear testimonials from alumni and celebrate achievements in the field of engineering."
            ),
            "2024-12-05" to Pair(
                "Lamparaan",
                "Get ready for the exciting Lamparaan event on December 5 at the UPang U Atrium! This day will feature creative lantern-making competitions, organized by the Supreme Student Council. Each group will showcase their handmade lanterns ('parols') as part of this cultural celebration."
            ),
            "2024-12-09" to Pair(
                "Ninging Project",
                "Participate in the Ninging Project on December 9! The event is organized by the International School of Tourism Management around Urdaneta. Join us for an exploration of tourism’s impact on local communities and the role of sustainable tourism practices."
            ),
            "2024-12-12" to Pair(
                "Lingapvika Community Outreach Program",
                "Support the Lingapvika Community Outreach Program on December 12, hosted by the Linguistic Society - ABEL at a local school. It's an opportunity to give back and engage with community service projects aimed at helping those in need."
            ),
            "2025-01-03" to Pair(
                "Eucharistic Celebration",
                "Join the UPang Flames Campus Youth Ministry for a Eucharistic Celebration on January 3 at the UPang U Atrium. It's a time for spiritual reflection and community."
            ),
            "2025-01-09" to Pair(
                "Strand Day",
                "Celebrate Strand Day on January 9, organized by the Supreme Student Government at the UPang U Atrium. This event brings together different academic strands for a day of collaboration, fun, and networking."
            ),
            "2025-01-14" to Pair(
                "Seminar for the DSPC Participants",
                "Attend the Seminar for the DSPC Participants on January 14, hosted by the Senior High School Advocates at the UPang U Atrium. It’s an informative event aimed at preparing students for their role in the upcoming DSPC."
            ),
            "2025-01-17" to Pair(
                "Tree Planting",
                "Join the Tree Planting event on January 7, organized by the Tactical Group, International School of Tourism Management, and Junior Philippine Institute of Accountants at Nancamaliran, Urdaneta City, Pangasinan. Contribute to environmental preservation efforts while fostering teamwork and community involvement."
            ),
            "2025-01-17" to Pair(
                "Seminar Caltech/Safety Training",
                "Enhance your knowledge with the Seminar on Caltech and Safety Training on January 17, organized by the Philippine Institute of Civil Engineers, Inc. - PUPU Chapter at the UPang U Atrium."
            )
        )


        binding.date.text = viewModel.date
        binding.title.text = eventMap[viewModel.date]?.first
        binding.description.text = eventMap[viewModel.date]?.second


        return binding.root;
    }


}