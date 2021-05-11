package com.example.semesterproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.semesterproject.databinding.FragmentProjectsBinding


class ProjectsFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProjectsBinding.inflate(inflater)
        val viewModel: ProjectViewModel by viewModels { ProjectViewModelFactory(requireContext()) }

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ProjectAdapter(ProjectAdapter.ProjectClickListener {
            viewModel.deleteActor(it)
        })
        binding.projectsRecyclerView.adapter = adapter

        viewModel.projects.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        // TODO !!!!!!!!!!
        binding.addBtn.setOnClickListener {
            viewModel.addActor(
                    binding.projectNameField.text.toString(),
                    binding.projectDiffField.text.toString(),
                    binding.movieTitleField.text.toString()
            )
        }
        // TODO !!!!!!!!!!
        binding.filterBtn.setOnClickListener {
            viewModel.filter(
                    binding.birthYearField.text.toString(),
                    binding.movieNameField.text.toString()
            )
        }

        return binding.root
    }

}