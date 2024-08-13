package io.nyxbit.phinma

import android.graphics.Color
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

        val courseList = listOf(
            "Course",
            "PHINMA UPang Basic Education Unit",
            "STEM (Science, Technology, Engineering and Mathematics)",
            "STEM HEALTH (Science, Technology, Engineering and Mathematic focus on Health)",
            "ABM (Accountancy, Business Administration)",
            "ABM HT(Accountancy, Business Administration focus on Hospitality and Tourism)",
            "HUMSS (Humanities &amp; Social Sciences)",
            "GAS (General Academic Strand)",
            "GAS (GAS with focus on Education)",
            "GAS (GAS with focus on Criminology)",
            "TVL (focus on COOKERY)",
            "TVL (focus on PROGRAMMING)",
            "Bachelor of Science in Accountancy",
            "Bachelor of Science in Management Accounting",
            "Bachelor of Science in Accountancy Technology",
            "Bachelor of Science in Hospitality Management",
            "Bachelor of Science in Tourism Management",
            "Bachelor of Science in Business Administration",
            "Bachelor of Science in Business Administration Major in Marketing Management",
            "Bachelor of Science in Business Administration Major in Financial Management",
            "Bachelor of Arts in Communication",
            "Bachelor of Arts in Political Science",
            "Bachelor of Science in Elementary Education",
            "Bachelor of Secondary Education",
            "Bachelor of Secondary Education Major in English",
            "Bachelor of Secondary Education Major in Math",
            "Bachelor of Secondary Education Major in Science",
            "Bachelor of Secondary Education Major in Social Studies",
            "Bachelor of Science in Criminology",
            "Bachelor of Science in Architecture",
            "Bachelor of Science in  Computer Engineering",
            "Bachelor of Science in Civil Engineering",
            "Bachelor of Science in Electrical Engineering",
            "Bachelor of Science in Mechanical Engineering",
            "Bachelor of Science in Electrical Engineering",
            "Bachelor of Science in Nursing",
            "Bachelor of Science in Pharmacy",
            "Bachelor in Medical Laboratory Science",
            "Bachelor of Science in Psychology",
            "Bachelor of Science in Information Technology",
            "Master of Arts in Education",
            "Master of Science in Management Engineering",
            "Doctor of Education in Higher Education",
            "Education Major in Educational Leadership",
            "Business Administration",
            "Bachelor of Laws"
        )
        val yearList = listOf("Year", "Year 1", "Year 2", "Year 3", "Year 4")


        binding.btnEdit.visibility = when (viewModel.initiator) {
            "Home" -> View.VISIBLE
            "Init" -> View.GONE
            else -> View.GONE
        }
        binding.header.header.setBackgroundColor(Color.parseColor(viewModel.school.primaryColor))

        binding.fullName.setText(viewModel.fullName)
        binding.address.setText(viewModel.address)
        binding.mobileNumber.setText(viewModel.mobileNumber)

        setupSpinner(binding.spinnerCourse, courseList)
        setupSpinner(binding.spinnerYear, yearList)

        binding.btnSave.setOnClickListener {
//            if (binding.fullName.text.toString().isNullOrEmpty()){
//                binding.nameError.visibility = View.VISIBLE
//                return@setOnClickListener
//            }else{
//                binding.nameError.visibility = View.INVISIBLE
//            }
//            if (binding.spinnerCourse.selectedItem == "Course"){
//                binding.courseError.visibility = View.VISIBLE
//                return@setOnClickListener
//            }else{
//                binding.courseError.visibility = View.INVISIBLE
//            }
//            if (binding.spinnerYear.selectedItem == "Year"){
//                binding.yearError.visibility = View.VISIBLE
//                return@setOnClickListener
//            }else{
//                binding.yearError.visibility = View.INVISIBLE
//            }
//            if (binding.address.text.toString().isNullOrEmpty()){
//                binding.addressError.visibility = View.VISIBLE
//                return@setOnClickListener
//            }else{
//                binding.addressError.visibility = View.INVISIBLE
//            }
//            if (binding.mobileNumber.text.toString().isNullOrEmpty()){
//                binding.numberError.visibility = View.VISIBLE
//                return@setOnClickListener
//            }else{
//                binding.numberError.visibility = View.INVISIBLE
//            }
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
