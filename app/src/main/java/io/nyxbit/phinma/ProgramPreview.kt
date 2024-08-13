package io.nyxbit.phinma

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import io.nyxbit.phinma.databinding.FragmentProgramPreviewBinding


class ProgramPreview : Fragment() {

    private lateinit var binding: FragmentProgramPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgramPreviewBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        binding.header.header.setBackgroundColor(Color.parseColor(viewModel.school.primaryColor))

        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.card_gradient) as GradientDrawable
        drawable.colors = intArrayOf(Color.parseColor(viewModel.school.primaryColor), Color.parseColor("#34202020"))

        val mainDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.card_gradient_invert) as GradientDrawable
        mainDrawable.colors = intArrayOf(Color.parseColor(viewModel.school.primaryColor), Color.parseColor(viewModel.school.secondaryColor))

        binding.imageCover.foreground = drawable
        binding.mainContent.background = mainDrawable

        val descriptions = listOf(
            "With PHINMA's RAD Learning, your distance is no longer a problem!\n\n" +
                    "You can now STUDY WHEREVER YOU ARE!\n" +
                    "‣ Learn from wherever you are\n" +
                    "‣ Finish 2-3 subjects in 1 month\n" +
                    "‣ Save on travel costs!\n" +
                    "‣ Learn using printed modules and through group discussions via virtual chats and calls\n" +
                    "‣ Suited for ALL STUDENTS (working, non-working, or undergrad) who need a flexible learning setup to finish college.",

            "Experience PHINMA's FLEX Learning: Enjoy a blend of distance and face-to-face classes with flexible scheduling.\n\n" +
                    "‣ 6-8 subjects per semester\n" +
                    "‣ Benefit from teacher support via calls, texts, or social media\n" +
                    "‣ Safeguard yourself with online options during the pandemic\n" +
                    "‣ Reduce travel expenses with less frequent campus visits\n" +
                    "‣ Adapt your learning to fit your personal style and schedule."
        )
        binding.apply {
            when (viewModel.initiator) {
                "FLEX" -> flexCards.visibility = View.VISIBLE
                "RAD" -> radCards.visibility = View.VISIBLE
            }
        }
        binding.tvAbbr.text = if (viewModel.initiator == "FLEX") {
            "Flex Learning"
        } else {
            "Remote and Distance Learning"
        }
        binding.tvProgramMode.text = if (viewModel.initiator == "FLEX") {
            "FLEX"
        } else {
            "RAD"
        }
        binding.tvProgramDescription.text = if (viewModel.initiator == "FLEX") {
            "Combination of distance learning + face-to-face sessions. A traditional way of 6-8 subjects in 1 semester."
        } else {
            "100% home-based learning; suited for working students who need a flexible learning setup, and to students who live far away and have difficulties traveling to come to school."
        }
        binding.tvDescription.text = if (viewModel.initiator == "FLEX") {
            descriptions[1]
        } else {
            descriptions[0]
        }

        return binding.root
    }


}