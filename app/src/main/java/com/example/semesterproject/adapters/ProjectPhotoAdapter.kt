package com.example.semesterproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.databinding.ItemProjectPhotoBinding
import com.example.semesterproject.models.Project

class ProjectPhotoAdapter (val clickListener: ProjectPhotoClickListener) :
    ListAdapter<Project, ProjectPhotoAdapter.ViewHolder>(ProjectDiffCallback()) {

    class ViewHolder(val binding: ItemProjectPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project, clickListener: ProjectPhotoClickListener) {
            binding.projectPh = project
            binding.clickListener = clickListener
        }
    }

    class ProjectDiffCallback : DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem.projectId == newItem.projectId
        }

        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem == newItem
        }
    }

    class ProjectPhotoClickListener(val clickListener: (project: Project) -> Unit) {
        fun onClick(project: Project) = clickListener(project)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProjectPhotoBinding
                .inflate(
                    LayoutInflater
                        .from(parent.context)
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }


}