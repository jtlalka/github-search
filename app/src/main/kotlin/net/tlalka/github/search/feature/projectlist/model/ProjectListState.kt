package net.tlalka.github.search.feature.projectlist.model

import net.tlalka.github.search.repository.model.Project

data class ProjectListState(
    val isLoading: Boolean = true,
    val results: List<Project> = emptyList()
)
