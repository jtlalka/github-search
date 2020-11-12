package net.tlalka.github.search.feature.projectlist.viewmodel

import net.tlalka.github.search.repository.model.Project

data class ProjectListViewState(
    val query: String,
    val projects: List<Project>,
    val loading: Boolean,
    val hasError: Boolean
) {

    companion object {

        val EMPTY: ProjectListViewState = ProjectListViewState(
            query = "",
            projects = emptyList(),
            loading = false,
            hasError = false
        )
    }
}
