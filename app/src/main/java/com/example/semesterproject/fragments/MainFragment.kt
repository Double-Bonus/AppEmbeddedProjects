package com.example.semesterproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.semesterproject.R
import com.example.semesterproject.databinding.FragmentMainBinding



/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,
            container, false)

        binding.btnFindProject.setOnClickListener{
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_projectsFragment)
        }

        binding.btnResistance.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_resistanceFragment)
        }

        binding.btnPartsInfo.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_sensorFragment)
        }

        binding.btnAllPrjcs.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_projectPhotoFragment)
        }

        return binding.root
    }

}