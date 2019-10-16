package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.tlalka.github.search.feature.projectlist.domain.FindProjectsUseCase
import net.tlalka.github.search.feature.projectlist.model.ProjectListState

class ProjectListViewModel(
    private val findProjects: FindProjectsUseCase
) : ViewModel() {

    private val projectListState = MutableLiveData<ProjectListState>(ProjectListState())

    init {
        // just for presentation result purpose
        searchByQuery("tetris")
    }

    fun getProjectListState(): LiveData<ProjectListState> = projectListState

    fun searchByQuery(query: String) {
        onLoadingQueryResult(query)
        fetchQueryData(query)
    }

    private fun onLoadingQueryResult(query: String) {
        projectListState.value = ProjectListState(
            query = query,
            isLoading = true,
            hasError = false,
            results = emptyList()
        )
    }

    private fun fetchQueryData(query: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                findProjects.findProjects(query)
            }.apply {
                projectListState.value = ProjectListState(
                    query = query,
                    isLoading = false,
                    hasError = second,
                    results = first
                )
            }
        }
    }
}
