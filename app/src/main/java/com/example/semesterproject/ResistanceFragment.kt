package com.example.semesterproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.room.PrimaryKey
import kotlin.math.pow


/**
 * A simple [Fragment] subclass.
 * Use the [ResistanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResistanceFragment : Fragment() {

    data class Band(
            val Color: String,
            val value: Double
    )

    data class ResVal(
            var resistance: Double,
            var tolerance: Double
    )



    // TODO can rename!!  ar tikrai mutable list reiktu???
    val color_digit = mutableListOf(
            Band("Black", 0.0),
            Band("Brown", 1.0),
            Band("Red", 2.0),
            Band("Orange", 3.0),
            Band("Yellow", 4.0),
            Band("Green", 5.0),
            Band("Blue", 6.0),
            Band("Violet", 7.0),
            Band("Grey", 8.0),
            Band("White", 9.0)
    )
    //TODO do we even need this list??
    val multiplier  = mutableListOf(
            Band("Black", 0.0),
            Band("Brown", 1.0),
            Band("Red", 2.0),
            Band("Orange", 3.0),
            Band("Yellow", 4.0),
            Band("Green", 5.0),
            Band("Blue", 6.0),
            Band("Violet", 7.0),
            Band("Grey", 8.0),
            Band("White", 9.0)
    )
    val tolerance   = mutableListOf(
            Band("Brown", 1.0),
            Band("Red", 2.0),
            Band("Green", 0.5),
            Band("Blue", 0.25),
            Band("Violet", 0.1),
            Band("Gold", 5.0),
            Band("Silver", 10.0),
            Band("None", 20.0)  // TODO chreck this!!!!!!
    )

    final val BAND_ERROR : Int = 0
    final val FOUR_BANDS : Int = 4
    final val FIVE_BANDS : Int = 5


    var bands_input = arrayOf<String>("","","","","") // returns Array<String?>
    var bands_cnt : Int = 5;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_resistance,
            container, false)


        //TODO can change this to data binding later!!
        val spinner: Spinner = view.findViewById(R.id.spin_firstBand)
        val spinner2: Spinner = view.findViewById(R.id.spin_secondBand)
        val spinner3: Spinner = view.findViewById(R.id.spin_thirdBand)
        val spinner4: Spinner = view.findViewById(R.id.spin_fourthBand)
        val spinner5: Spinner = view.findViewById(R.id.spin_fifthBand)
        val switch : Switch = view.findViewById(R.id.switch_bandCnt)

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

        // TODO maybe use final?? id databindg is not used?
        val cacl_bnt: Button = view.findViewById(R.id.btn_cacl_resistance)
        cacl_bnt.setOnClickListener {
           // val stringValss: String = spinner5.selectedView.toString()

            //val tesss:Int =  get_spinners_input(stringValss)

            bands_input[0] = spinner.selectedItem.toString()
            bands_input[1] = spinner2.selectedItem.toString()
            bands_input[2] = spinner3.selectedItem.toString()
            bands_input[3] = spinner4.selectedItem.toString()
            bands_input[4] = spinner5.selectedItem.toString()




            val textView : TextView = view.findViewById(R.id.text_omh_value)

            var resistor_val : ResVal
            if(bands_cnt == 5)
                resistor_val = caclulate_resistance_five(bands_input)
            else
                resistor_val = caclulate_resistance_four(bands_input)


            if(resistor_val.resistance != 0.0 && resistor_val.tolerance != -100.0){
                textView.text = resistor_val.resistance.toString() + " Omhs with tolerance of +/- " +
                        resistor_val.tolerance.toString()
            } else{
                textView.text = "Invalid color map"
            }


            //caclulate_resistance("lops")
            //spinner5.
            //stringTess = spinner5.selectedView.toString()
        }

        switch.setOnClickListener {
            val band_textView : TextView = view.findViewById(R.id.text_band_5)
            if (switch.isChecked){
                bands_cnt = 4
                spinner5.visibility = View.INVISIBLE
                band_textView.visibility = View.INVISIBLE
            } else {
                bands_cnt = 5
                spinner5.visibility = View.VISIBLE
                band_textView.visibility = View.VISIBLE
            }
            val textView : TextView = view.findViewById(R.id.text_bands)
            textView.text = bands_cnt.toString() + " bands"

        }
       // val string: String = R.array.resistor_color.toString(0)



        return view
    }

    // galim array iskart paduot!
    private fun get_spinners_input(spin1: String?, spin2: String?, spin3: String?,
                                   spin4: String?, spin5: String? ): Int {
        if (spin1 != null)
            if (spin1.equals(R.array.resistor_color.toString(1)))
                return 1
        return  0
    }


    fun caclulate_resistance(name: String?): Unit {
        if (name != null)
            println("Hello $name")
        else
            println("Hi there!")
        // `return Unit` or `return` is optional
    }




    private fun caclulate_resistance_five(spinners_input : Array<String> ): ResVal {
        var calc  = ResVal(0.0,-100.0)
        var values = arrayOf<Double>(-1.0,-1.0,-1.0,-1.0,-1.0) // returns Array<String?>
        for (i in 0..2) {
            for (j in 0..(color_digit.size-1)) {
                if (spinners_input[i] == color_digit[j].Color){
                    values[i] = color_digit[j].value
                    break
                }
            }
            if(values[i] == -1.0){ // not valid input
                return calc // TODO EINA NX KAIP CIA BLOHAI!
            }
        }


        //TODO This is so retarded
        //Multipleplyer
        for (i in 0..(multiplier.size-1)) {
            if (spinners_input[3] == multiplier[i].Color){
                values[3] = multiplier[i].value
                break
            }
        }
        if(values[3] == -1.0){ // not valid input for multiplayer
            return calc // TODO EINA NX KAIP CIA BLOHAI!
        }



        //Tolerance
        for (i in 0..(tolerance.size-1)) {
            if (spinners_input[4] == tolerance[i].Color){
                values[4] = tolerance[i].value
                break
            }
        }
        if(values[4] == -1.0){ // not valid input for multiplayer
            return calc // TODO EINA NX KAIP CIA BLOHAI!
        }


        calc.resistance = (values[0]*100 + values[1]*10 + values[2])*10.0.pow(values[3])
        calc.tolerance = values[4]





            return calc
    }

    private fun caclulate_resistance_four(spinners_input : Array<String> ): ResVal {
        var calc  = ResVal(0.0,-100.0)
        var values = arrayOf<Double>(-1.0,-1.0,-1.0,-1.0) // returns Array<String?>
        for (i in 0..1) {
            for (j in 0..(color_digit.size-1)) {
                if (spinners_input[i] == color_digit[j].Color){
                    values[i] = color_digit[j].value
                    break
                }
            }
            if(values[i] == -1.0){ // not valid input
                return calc // TODO EINA NX KAIP CIA BLOHAI!
            }
        }


        //TODO This is so retarded
        //Multipleplyer
        for (i in 0..(multiplier.size-1)) {
            if (spinners_input[2] == multiplier[i].Color){
                values[2] = multiplier[i].value
                break
            }
        }
        if(values[2] == -1.0){ // not valid input for multiplayer
            return calc // TODO EINA NX KAIP CIA BLOHAI!
        }



        //Tolerance
        for (i in 0..(tolerance.size-1)) {
            if (spinners_input[3] == tolerance[i].Color){
                values[3] = tolerance[i].value
                break
            }
        }
        if(values[3] == -1.0){ // not valid input for multiplayer
            return calc // TODO EINA NX KAIP CIA BLOHAI!
        }


        calc.resistance = (values[0]*10 + values[1] )*10.0.pow(values[2])
        calc.tolerance = values[3]





        return calc
    }









}