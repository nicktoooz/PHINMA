package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentChooseSchoolBinding


class ChooseSchool : Fragment() {

    private lateinit var binding :FragmentChooseSchoolBinding
    private lateinit var viewModel : ViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseSchoolBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]


        setNavigation(binding.upangUrdaneta, R.id.action_chooseSchool_to_profile, "UPang Urdaneta")
        setNavigation(binding.rizal, R.id.action_chooseSchool_to_profile, "Rizal")
        setNavigation(binding.jude, R.id.action_chooseSchool_to_profile, "Foobar")

        return binding.root
    }

    private fun setNavigation(button: ImageView, destination: Int, school: String){
        button.setOnClickListener {
            viewModel.school = school
            viewModel.initiator = "Init"
            findNavController().navigate(destination)
        }
    }


}