package com.example.semesterproject.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.semesterproject.adapters.SensorAdapter
import com.example.semesterproject.models.Sensor

@BindingAdapter("sensorImage")
fun ImageView.setDogImage(sensor: Sensor) {
    Glide.with(this).load(sensor.imageUrl).into(this)
}

@BindingAdapter("sensors")
fun RecyclerView.setDogs(sensors: List<Sensor>?) {
    sensors?.let { (adapter as SensorAdapter).submitList(sensors) }
}