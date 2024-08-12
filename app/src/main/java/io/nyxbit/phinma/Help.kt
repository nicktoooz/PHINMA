package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentHelpBinding


class Help : Fragment() {


    private lateinit var binding : FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        binding = FragmentHelpBinding.inflate(inflater,container,false)

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