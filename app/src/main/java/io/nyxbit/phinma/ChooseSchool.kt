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


enum class School(val value: String, val emblem: Int, val primaryColor: String, secon: String, mapUrl: String) {
    NONE("", R.mipmap.ic_launcher_round, "#FFFFFF", "#FFFFFF", "https://www.google.com/maps"),
    PUCU("PHINMA UPang College Urdaneta", R.drawable.emblem_pucu, "#3b4c23", "#a98d00", "https://www.google.com/maps/place/PHINMA+UPANG+College+Urdaneta/@15.9691687,120.5718125,389m/data=!3m1!1e3!4m6!3m5!1s0x33913fab6540dcdd:0xde4220ea0771817a!8m2!3d15.9697648!4d120.5722016!16s%2Fg%2F11cllnrqn1?entry=ttu"),
    UPANG("PHINMA University of Pangasinan", R.drawable.emblem_upang, "#3b4c23", "#a98d00", "https://www.google.com/maps/place/PHINMA-University+of+Pangasinan/@16.0471605,120.3425506,195m/data=!3m1!1e3!4m6!3m5!1s0x339167fe6bba4d67:0xf54b516c2c5d10b6!8m2!3d16.0471041!4d120.3425147!16s%2Fm%2F0641gkp?entry=ttu"),
    JUDE("PHINMA Saint Jude College", R.drawable.emblem_jude, "#1b4c43", "#d79a2a", "https://www.google.com/maps/place/PHINMA+Saint+Jude+College+Manila/@14.6157314,120.9893056,120m/data=!3m1!1e3!4m6!3m5!1s0x3397b6073e440f95:0xf3a914ffca4b7cab!8m2!3d14.615804!4d120.989291!16s%2Fg%2F125_jy_n3?entry=ttu"),
    RIZAL("PHINMA Rizal College of Laguna", R.drawable.emblem_rizal, "#2a224a", "#9494a1", "https://www.google.com/maps/place/PHINMA+Rizal+College+of+Laguna/@14.2103107,121.154062,391m/data=!3m1!1e3!4m6!3m5!1s0x33bd63cc631e804d:0x9b3f33a265fa77ff!8m2!3d14.2104247!4d121.154172!16s%2Fg%2F125_k32jx?entry=ttu"),
    ILOILO("PHINMA University of Iloilo", R.drawable.emblem_iloilo, "#324b22", "#f5ca00", "https://www.google.com/maps/place/PHINMA+UNIVERSITY+OF+ILOILO/@10.6917891,122.5694796,196m/data=!3m1!1e3!4m6!3m5!1s0x33aee5255345f11b:0xb32057bb6b1d39c8!8m2!3d10.6919187!4d122.5695938!16zL20vMGY4emhq?entry=ttu"),
    ARAULLO("PHINMA Araullo University", R.drawable.emblem_araullo, "#183060", "#bc9c26", "https://www.google.com/maps/place/PHINMA+Araullo+University/@15.4953826,120.97565,153m/data=!3m1!1e3!4m6!3m5!1s0x3397293ac508a10b:0x81ce23ee09fe5103!8m2!3d15.495358!4d120.975771!16zL20vMGRtN25s?entry=ttu"),
    CDO("PHINMA Cagayan De Oro College", R.drawable.emblem_cdo, "#0d4d24", "#92840f", "https://www.google.com/maps/place/PHINMA+-+Cagayan+de+Oro+College+(COC)/@8.4816387,124.6358433,186m/data=!3m1!1e3!4m6!3m5!1s0x32fff32678db4a4d:0x3fc6f10f4d0966e5!8m2!3d8.4817536!4d124.6359652!16s%2Fm%2F03wh0f6?entry=ttu"),
    SOUTHWESTERN("SOUTHWESTERN UNIVERSITY", R.drawable.emblem_southwestern, "#9b0b0b", "#232C64", "https://www.google.com/maps/place/Southwestern+University+(SWU)+PHINMA/@10.3041957,123.8886716,357m/data=!3m1!1e3!4m6!3m5!1s0x33a9995396ee3a2b:0xf4f76cc2e3810ab!8m2!3d10.3031864!4d123.8913056!16s%2Fm%2F04gkgm4?entry=ttu"),
    UNION("PHINMA Union College of Laguna", R.drawable.emblem_laguna, "#442482", "#d79a2a", "https://www.google.com/maps/place/PHINMA+Union+College+of+Laguna/@14.2833816,121.416087,112m/data=!3m1!1e3!4m6!3m5!1s0x3397e36c1b0f98fb:0x24544067ea561942!8m2!3d14.283369!4d121.416111!16s%2Fg%2F12q4v2hpz?entry=ttu"),
    REPUBLICAN("PHINMA Republican College", R.drawable.emblem_republican, "#1b4c43", "#d79a2a", "https://www.google.com/maps/place/PHINMA+Republican+College-+Aurora+Building/@14.6760524,121.043655,111m/data=!3m1!1e3!4m6!3m5!1s0x3397b72fc9abf57f:0xf22d4df46a56e0a4!8m2!3d14.6760413!4d121.0437003!16s%2Fg%2F12qh9qjcc?entry=ttu");
    val secondaryColor: String = secon
    val map: String = mapUrl
}
