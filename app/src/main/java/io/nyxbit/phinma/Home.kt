package io.nyxbit.phinma

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            val colourScheme = when(viewModel.school) {
                School.PUCU -> Color.RED
                else -> Color.BLUE
            }
            btnProfile.setBackgroundColor(colourScheme)
        }
        binding.ivEmblem.setImageResource(viewModel.school.emblem)
        binding.tvName.text = "Hi ${viewModel.fullName.trim().split(" ").firstOrNull()}!"
        binding.tvSchool.text = viewModel.school.value
        binding.btnPrograms.setOnClickListener { findNavController().navigate(R.id.action_home2_to_help) }
        binding.btnProfile.setOnClickListener {
            viewModel.initiator = "Home"
            findNavController().navigate(R.id.action_home2_to_profile)
        }
        binding.btnMap.setOnClickListener { findNavController().navigate(R.id.action_home2_to_schoolMap) }
        binding.btnChangeUser.setOnClickListener { findNavController().popBackStack(R.id.chooseSchool, false)}

        return binding.root
    }

}