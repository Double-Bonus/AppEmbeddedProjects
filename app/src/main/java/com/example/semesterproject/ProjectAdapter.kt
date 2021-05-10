package com.example.semesterproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.semesterproject.databinding.ItemProjectBinding


class ProjectAdapter(val clickListener: ActorClickListener) :
        ListAdapter<Project, ProjectAdapter.ViewHolder>(ActorDiffCallback()) {

    class ViewHolder(val binding: ItemProjectBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project, clickListener: ActorClickListener) {
            binding.project = project
            binding.clickListener = clickListener
        }
    }

    class ActorDiffCallback : DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem.projectId == newItem.projectId
        }

        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem == newItem
        }
    }

    class ActorClickListener(val clickListener: (actor: Project) -> Unit) {
        fun onClick(actor: Project) {
            clickListener(actor)
        }
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