package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentProfileBinding

class Profile : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        // Initialize the course and year lists
        val courseList = listOf("Course 1", "Course 2", "Course 3", "Course 4", "Course 5")
        val yearList = listOf("Year 1", "Year 2", "Year 3", "Year 4", "Year 5")

        binding.btnEdit.visibility = when(viewModel.initiator){
            "Home"-> View.VISIBLE
            "Init"-> View.GONE
            else -> View.GONE
        }

        binding.fullName.setText(viewModel.fullName)
        binding.address.setText(viewModel.address)
        binding.mobileNumber.setText(viewModel.mobileNumber)

        // Set up the spinners
        setupSpinner(binding.spinnerCourse, courseList)
        setupSpinner(binding.spinnerYear, yearList)

        binding.btnSave.setOnClickListener {
            viewModel.fullName = binding.fullName.text.toString()
            viewModel.address = binding.address.text.toString()
            viewModel.mobileNumber = binding.mobileNumber.text.toString()

            findNavController().navigate(R.id.action_profile_to_home2)
        }
        return binding.root
    }

    private fun setupSpinner(spinner: Spinner, items: List<String>) {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            items
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter
    }
}
