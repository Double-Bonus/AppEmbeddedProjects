package com.example.semesterproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.databinding.ItemProjectBinding
import com.example.semesterproject.models.Project


class ProjectAdapter(val clickListener: ProjectClickListener) :
        ListAdapter<Project, ProjectAdapter.ViewHolder>(ProjectDiffCallback()) {

    class ViewHolder(val binding: ItemProjectBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project, clickListener: ProjectClickListener) {
            binding.project = project
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

    class ProjectClickListener(val clickListener: (project: Project) -> Unit) {
        fun onClick(project: Project) = clickListener(project)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                ItemProjectBinding
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