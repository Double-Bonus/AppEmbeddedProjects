package com.example.semesterproject.utils

import com.example.semesterproject.R
import com.example.semesterproject.models.Sensor
import kotlin.random.Random

object MockData {
    val sensors = listOf(
        Sensor(0,
        R.drawable.dc_motor,
        "DC-motor",
        "A brushed DC electric motor generating torque from DC " +
                "power supply by using an internal mechanical commutation." +
                " Stationary permanent magnets form the stator field."),
        Sensor(0,
            R.drawable.mcu,
            "MCU",
            "When developing an embedded system, one of the options is to base" +
                    " the computational hardware around a microcontroller, " +
                    "MCU rather than a microprocessor, MPU."),
        Sensor(0,
            R.drawable.acc,
            "Acc",
            "An accelerometer is an electronic sensor that measures the acceleration" +
                    " forces acting on an object, in order to determine the object’s" +
                    " position in space and monitor the object’s movement. "),

        Sensor(0,
            R.drawable.hydro,
            "Hydro",
            "        Hydroponics is considered a relatively light duty application for" +
                    " pH and electrical conductivity sensors. This makes sense, because typically" +
                    " if a plant can survive in the environment, then so can a sensor."),



        Sensor(0,
            R.drawable.resistor,
            "Resistor",
            "A resistor is a passive two-terminal electrical component that implements electrical" +
                    " resistance as a circuit element. In electronic circuits, resistors are used to reduce" +
                    " current flow, adjust signal levels, to divide voltages, bias active elements," +
                    " and terminate transmission lines, among other uses."),

        Sensor(0,
            R.drawable.ble,
            "BLE",
            "Bluetooth Low Energy (Bluetooth LE, colloquially BLE, formerly marketed" +
                    " as Bluetooth Smart) is a wireless personal area network technology" +
                    " designed and marketed by the Bluetooth Special Interest Group" +
                    " (Bluetooth SIG) aimed at novel applications in the healthcare, fitness," +
                    " beacons, security, and home entertainment industries"),


        Sensor(0,
            R.drawable.wheels,
            "Wheels",
            "Basic wheels needed for robot to be able to move"),

        Sensor(0,
            R.drawable.rtc,
            "RTC",
            "A real-time clock (RTC) is an electronic device (most often in the form of an" +
                    " integrated circuit) that measures the passage of time."),


        Sensor(0,
            R.drawable.lcd,
            "LCD",
            "A liquid-crystal display (LCD) is a flat-panel display or other " +
                    "electronically modulated optical device that uses the light-modulating" +
                    " properties of liquid crystals combined with polarizers. Liquid crystals do" +
                    " not emit light directly,[1] instead using a backlight or reflector to produce images in color or monochrome"),

        Sensor(0,
            R.drawable.ultra_s,
            "Ultrasonic sensor",
            "Ultrasonic transducers and ultrasonic sensors are devices that" +
                    " generate or sense ultrasound energy"),
        Sensor(0,
            R.drawable.led,
            "LED",
            "A light-emitting diode (LED) is a semiconductor light source tha" +
                    " emits light when current flows through it. Electrons in the semiconductor" +
                    " recombine with electron holes, releasing energy in the form of photons. "),
        Sensor(0,
            R.drawable.air,
            "Air-quality sensor",
            "These sensors work on the principle of measuring the attenuation of infrared" +
                    " radiation (with a specific wave length) in the air. The sensors consist of" +
                    " an infrared radiation source, a light-water pipe and the infrared detector" +
                    " with the appropriate filter."),


    )

    fun getRandomSensor(): Sensor = sensors[Random.nextInt(0, sensors.size)]
}