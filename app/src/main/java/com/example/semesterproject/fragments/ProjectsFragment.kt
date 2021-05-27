package com.example.semesterproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.semesterproject.adapters.ProjectAdapter
import com.example.semesterproject.database.ProjectDatabase
import com.example.semesterproject.databinding.FragmentProjectsBinding
import com.example.semesterproject.viewmodels.ProjectViewModel
import com.example.semesterproject.viewmodels.ProjectViewModelFactory


class ProjectsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProjectsBinding.inflate(inflater)

        val viewModel : ProjectViewModel by viewModels {
            ProjectViewModelFactory(
                ProjectDatabase.getInstance(
                    requireContext()
                )
            )
        }

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ProjectAdapter(ProjectAdapter.ProjectClickListener {
            viewModel.deleteProject(it)
        })
        binding.projectsRecyclerView.adapter = adapter

        viewModel.projects.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        // TODO
        binding.addBtn.setOnClickListener {
            viewModel.addProject(
                binding.projectNameField.text.toString(),
                binding.projectDiffField.text.toString(),
                binding.movieTitleField.text.toString(),
                    binding.checkBoxDc.isChecked,
                    binding.checkBoxBle.isChecked,
                    binding.checkBoxWheel.isChecked,
                    binding.checkBoxRtc.isChecked,
                    binding.checkBoxLcd.isChecked,
                    binding.checkBoxUltraS.isChecked,
                    binding.checkBoxLed.isChecked,
                    binding.checkBoxAir.isChecked,
                    binding.checkBoxMcu2.isChecked,
                    binding.checkBoxAcc2.isChecked,
                    binding.checkBoxHyd2.isChecked,
                    binding.checkBoxRes.isChecked
            )
        }
        // TODO
        binding.filterBtn.setOnClickListener {
            viewModel.filter(
                binding.difficultyField.text.toString(),
                binding.movieNameField.text.toString()
            )
        }

        binding.bntFindPrjc.setOnClickListener {
            viewModel.findProject(
                    binding.checkBoxDc.isChecked,
                    binding.checkBoxBle.isChecked,
                    binding.checkBoxWheel.isChecked,
                    binding.checkBoxRtc.isChecked,
                    binding.checkBoxLcd.isChecked,
                    binding.checkBoxUltraS.isChecked,
                    binding.checkBoxLed.isChecked,
                    binding.checkBoxAir.isChecked,
                    binding.checkBoxMcu2.isChecked,
                    binding.checkBoxAcc2.isChecked,
                    binding.checkBoxHyd2.isChecked,
                    binding.checkBoxRes.isChecked
            )
        }


        return binding.root
    }


}

