package com.example.semesterproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
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
        /*
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.btn_findProject).setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_projectsFragment)
        }
        return view
        */

        binding.btnFindProject.setOnClickListener{
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_projectsFragment)
        }

        binding.btnResistance.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_mainFragment_to_resistanceFragment)
        }

        return binding.root
/*
        binding.btnFindProject.setOnClickListener {
            //val action = ProjectsFragmentDirections.actionMainFragmentToMovieFragment()
            val action = MainFragmentDirections.actionMainFragmentToProjectsFragment()
            binding.root.findNavController().navigate(action)
        }

        return binding.root

 */
    }

}