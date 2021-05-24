package com.example.semesterproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.semesterproject.adapters.ProjectPhotoAdapter
import com.example.semesterproject.database.ProjectDatabase
import com.example.semesterproject.databinding.FragmentProjectPhotoBinding
import com.example.semesterproject.viewmodels.ProjectPhotoViewModel
import com.example.semesterproject.viewmodels.ProjectPhotoViewModelFactory


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


        val viewModel : ProjectPhotoViewModel by viewModels {
            ProjectPhotoViewModelFactory(
                    ProjectDatabase.getInstance(
                            requireContext()
                    )
            )
        }

        /*
        val viewModel: ProjectPhotoViewModel by viewModels {
            ProjectPhotoViewModelFactory(requireContext()) }
*/
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ProjectPhotoAdapter(ProjectPhotoAdapter.ProjectPhotoClickListener {
            //viewModel.deleteActor(it)
        })
        binding.prjPhRecyclerView.adapter = adapter

        //TODO do wee need this?
        viewModel.projectsPh.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        return binding.root
    }


}
