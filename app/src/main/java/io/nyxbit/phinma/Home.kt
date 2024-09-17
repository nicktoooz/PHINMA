package io.nyxbit.phinma

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentHomeBinding


class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        binding.apply{

            val color = Color.parseColor(viewModel.school.primaryColor)
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.btn_background)
            drawable?.setTint(color)

            btnCourses.background = drawable
            btnPrograms.background = drawable
            btnProfile.background = drawable
            btnScholarship.background = drawable
            btnMap.background = drawable
            btnChangeUser.background = drawable
            btnCalendar.background = drawable

        }
        binding.ivEmblem.setImageResource(viewModel.school.emblem)
        binding.tvName.text = "Hi ${viewModel.fullName.trim().split(" ").firstOrNull()}!"
        binding.tvSchool.text = viewModel.school.value
        binding.btnPrograms.setOnClickListener { findNavController().navigate(R.id.action_home2_to_help) }
        binding.btnCourses.setOnClickListener { findNavController().navigate(R.id.action_home2_to_courseOffering) }
        binding.btnProfile.setOnClickListener {
            viewModel.initiator = "Home"
            findNavController().navigate(R.id.action_home2_to_profile)
        }
        binding.btnScholarship.setOnClickListener { findNavController().navigate(R.id.action_home2_to_scholarship) }
        binding.btnMap.setOnClickListener { findNavController().navigate(R.id.action_home2_to_schoolMap) }
        binding.btnChangeUser.setOnClickListener {
            viewModel.clear()
            findNavController().popBackStack(R.id.chooseSchool, false)
        }
        binding.btnCalendar.setOnClickListener { findNavController().navigate(R.id.action_home2_to_fragmentCalendar) }

        return binding.root
    }
}