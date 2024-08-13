package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        setNavigation(binding.cdo, R.id.action_chooseSchool_to_profile, School.CDO)
        setNavigation(binding.southwestern, R.id.action_chooseSchool_to_profile, School.SOUTHWESTERN)
        setNavigation(binding.union, R.id.action_chooseSchool_to_profile, School.UNION)
        setNavigation(binding.republican, R.id.action_chooseSchool_to_profile, School.REPUBLICAN)
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


enum class School(val value: String, val emblem: Int, val primaryColor: String, secon: String) {
    NONE("", R.mipmap.ic_launcher_round, "#FFFFFF", "#FFFFFF"),
    PUCU("PHINMA UPang College Urdaneta", R.drawable.emblem_pucu, "#3b4c23", "#a98d00"),
    UPANG("PHINMA University of Pangasinan", R.drawable.emblem_upang, "#3b4c23", "#a98d00"),
    JUDE("PHINMA Saint Jude College", R.drawable.emblem_jude, "#1b4c43", "#d79a2a"),
    RIZAL("PHINMA Rizal College of Laguna", R.drawable.emblem_rizal, "#2a224a", "#9494a1"),
    ILOILO("PHINMA University of Iloilo", R.drawable.emblem_iloilo, "#324b22", "#f5ca00"),
    ARAULLO("PHINMA Araullo University", R.drawable.emblem_araullo, "#183060", "#bc9c26"),
    CDO("PHINMA Cagayan De Oro College", R.drawable.emblem_cdo, "#0d4d24", "#92840f"),
    SOUTHWESTERN("SOUTHWESTERN UNIVERSITY", R.drawable.emblem_southwestern, "#9b0b0b", "#232C64"),
    UNION("PHINMA Union College of Laguna", R.drawable.emblem_laguna, "#442482", "#d79a2a"),
    REPUBLICAN("PHINMA Republican College", R.drawable.emblem_republican, "#1b4c43", "#d79a2a");
    val secondaryColor: String = secon
}
