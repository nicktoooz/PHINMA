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
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentHelpBinding


class Help : Fragment() {


    private lateinit var binding : FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.card_gradient) as GradientDrawable
        drawable.colors = intArrayOf(Color.parseColor(viewModel.school.primaryColor), Color.parseColor("#34202020"))
        binding.imgA.foreground = drawable
        binding.imgB.foreground = drawable
        binding.header.header.setBackgroundColor(Color.parseColor(viewModel.school.primaryColor))

        binding.flex.setOnClickListener{
            viewModel.initiator = "FLEX"
            findNavController().navigate(R.id.action_help_to_programPreview)
        }
        binding.rad.setOnClickListener {
            viewModel.initiator = "RAD"
            findNavController().navigate(R.id.action_help_to_programPreview)
        }




        return binding.root
    }


}