package io.nyxbit.phinma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.nyxbit.phinma.databinding.FragmentProgramPreviewBinding


class ProgramPreview : Fragment() {

    private lateinit var binding : FragmentProgramPreviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProgramPreviewBinding.inflate(inflater,container,false)

        return binding.root
    }


}