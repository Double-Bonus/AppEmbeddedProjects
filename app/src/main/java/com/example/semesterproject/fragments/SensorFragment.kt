package com.example.semesterproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.semesterproject.adapters.SensorAdapter
import com.example.semesterproject.database.SensorDatabase
import com.example.semesterproject.databinding.FragmentSensorBinding
import com.example.semesterproject.viewmodels.SensorsViewModel
import com.example.semesterproject.viewmodels.SensorsViewModelFactory


class SensorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSensorBinding.inflate(inflater)

        val viewModel : SensorsViewModel by viewModels {
            SensorsViewModelFactory(
                SensorDatabase.getInstance(
                    requireContext()
                )
            )
        }

        val adapter = SensorAdapter(SensorAdapter.SenorClickListener{
        })

        binding.sensorsRecyclerView.adapter = adapter

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}