package net.tlalka.github.search.feature.projectlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.tlalka.github.search.databinding.ProjectListItemBinding
import net.tlalka.github.search.databinding.ProjectListItemBinding.inflate
import net.tlalka.github.search.repository.model.Project

class ProjectsAdapter : ListAdapter<Project, ProjectsAdapter.ViewHolder>(ProjectsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder(
        private val binding: ProjectListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(project: Project) {
            binding.item = project
        }
    }
}