package io.nyxbit.phinma

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import io.nyxbit.phinma.databinding.FragmentScholarshipBinding

class Scholarship : Fragment() {

    private lateinit var binding : FragmentScholarshipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScholarshipBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]
        binding.header.header.setBackgroundColor(Color.parseColor(viewModel.school.primaryColor))
        return binding.root
    }

}