package com.example.semesterproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.semesterproject.adapters.ProjectAdapter
import com.example.semesterproject.database.ProjectDatabase
import com.example.semesterproject.databinding.FragmentProjectPhotoBinding
import com.example.semesterproject.viewmodels.ProjectViewModel
import com.example.semesterproject.viewmodels.ProjectViewModelFactory


class ProjectPhotoFragment : Fragment() {

    /*
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_photo, container, false)
    }
    */



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProjectPhotoBinding.inflate(inflater)


        val viewModel : ProjectViewModel by viewModels {
            ProjectViewModelFactory(
                    ProjectDatabase.getInstance(
                            requireContext()
                    )
            )
        }

        /*
        val viewModel: ProjectViewModel by viewModels {
            ProjectViewModelFactory(requireContext()) }
*/
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ProjectAdapter(ProjectAdapter.ProjectClickListener {
            viewModel.deleteActor(it)
        })
        binding.prjPhRecyclerView.adapter = adapter

        //TODO do wee need this?
        viewModel.projects.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        /*
        // TODO !!!!!!!!!!
        binding.addBtn.setOnClickListener {
            //viewModel.addActor()
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
        */

        return binding.root
    }


}
