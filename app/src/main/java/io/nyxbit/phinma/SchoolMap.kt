package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.nyxbit.phinma.databinding.FragmentSchoolMapBinding

class SchoolMap : Fragment() {

    private lateinit var binding : FragmentSchoolMapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSchoolMapBinding.inflate(inflater,container,false)




        return binding.root

    }


}