package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import io.nyxbit.phinma.databinding.FragmentChooseSchoolBinding


class ChooseSchool : Fragment() {

    private lateinit var binding: FragmentChooseSchoolBinding
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseSchoolBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[ViewModel::class.java]

        setNavigation(binding.pucu, R.id.action_chooseSchool_to_profile, School.PUCU)
        setNavigation(binding.upang, R.id.action_chooseSchool_to_profile, School.UPANG)
        setNavigation(binding.jude, R.id.action_chooseSchool_to_profile, School.JUDE)
        setNavigation(binding.rizal, R.id.action_chooseSchool_to_profile, School.RIZAL)
        setNavigation(binding.iloilo, R.id.action_chooseSchool_to_profile, School.ILOILO)
        setNavigation(binding.araullo, R.id.action_chooseSchool_to_profile, School.ARAULLO)

        return binding.root
    }

    private fun setNavigation(button: CardView, destination: Int, school: School) {
        button.setOnClickListener {
            viewModel.school = school
            viewModel.initiator = "Init"
            findNavController().navigate(destination)
        }
    }
}

enum class School(val value: String, val emblem: Int) {
    NONE("", R.mipmap.ic_launcher_round),
    PUCU("PHINMA UPang College Urdaneta", R.drawable.emblem_pucu),
    UPANG("PHINMA University of Pangasinan", R.drawable.emblem_upang),
    JUDE("PHINMA Saint Jude College", R.drawable.emblem_jude),
    RIZAL("PHINMA Rizal College of Laguna", R.drawable.emblem_rizal),
    ILOILO("PHINMA University of Iloilo", R.drawable.emblem_iloilo),
    ARAULLO("PHINMA Araullo University", R.drawable.emblem_araullo)
}
