package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.tlalka.github.search.feature.projectlist.domain.FindProjectsUseCase
import net.tlalka.github.search.feature.projectlist.model.ProjectListState

class ProjectListViewModel(
    private val findProjects: FindProjectsUseCase
) : ViewModel() {

    private val projectListState = MutableLiveData<ProjectListState>(ProjectListState())

    fun getProjectListState(): LiveData<ProjectListState> = projectListState

    fun searchByQuery(query: String) {
        projectListState.value = ProjectListState(
            isLoading = false,
            results = findProjects.findProjects(query)
        )
    }
}
