package com.example.semesterproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.databinding.ItemSensorBinding
import com.example.semesterproject.models.Sensor

class SensorAdapter (private val clickListener: SenorClickListener) :
    ListAdapter<Sensor, SensorAdapter.ViewHolder>(SensorDiffCallback()) {

    class ViewHolder(private val binding: ItemSensorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sensor: Sensor, clickListener: SenorClickListener) {
            binding.sensors = sensor
            binding.clickListener = clickListener
        }
    }

    class SensorDiffCallback : DiffUtil.ItemCallback<Sensor>() {
        override fun areItemsTheSame(oldItem: Sensor, newItem: Sensor): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sensor, newItem: Sensor): Boolean {
            return oldItem == newItem
        }

    }


    // TODO delete?
    class SenorClickListener(private val clickListener: (sensor: Sensor) -> Unit){
        fun onClick(sensor: Sensor) = clickListener(sensor)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(ItemSensorBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}