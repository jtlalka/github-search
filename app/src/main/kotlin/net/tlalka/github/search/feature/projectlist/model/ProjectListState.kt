package net.tlalka.github.search.feature.projectlist.model

import net.tlalka.github.search.repository.model.Project

data class ProjectListState(
    val query: String = "",
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val results: List<Project> = emptyList()
)
