package com.example.semesterproject.utils

import com.example.semesterproject.R
import com.example.semesterproject.models.Sensor
import kotlin.random.Random

object MockData {
    val sensors = listOf(
        Sensor(0,
        R.drawable.owner_macfarlane_192,
        "Light",
        "Does some good stuf"),
        Sensor(0,
            R.drawable.owner_pitt_192,
            "Thermo",
            "Does some bad stuf"),
        Sensor(0,
            R.drawable.owner_macfarlane_192,
            "Acc",
            "Does some moveing stuf"),

    )

    fun getRandomSensor(): Sensor = sensors[Random.nextInt(0, sensors.size)]
}