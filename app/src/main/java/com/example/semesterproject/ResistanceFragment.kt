package com.example.semesterproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner


/**
 * A simple [Fragment] subclass.
 * Use the [ResistanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResistanceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_resistance,
            container, false)

        val spinner: Spinner = view.findViewById(R.id.spin_firstBand)
        val spinner2: Spinner = view.findViewById(R.id.spin_secondBand)
        val spinner3: Spinner = view.findViewById(R.id.spin_thirdBand)
        val spinner4: Spinner = view.findViewById(R.id.spin_fourthBand)
        val spinner5: Spinner = view.findViewById(R.id.spin_fifthBand)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this.requireContext(),
        R.array.resistor_color,
        android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner2.adapter = adapter
            spinner3.adapter = adapter
            spinner4.adapter = adapter
            spinner5.adapter = adapter
        }



        return view
    }


}