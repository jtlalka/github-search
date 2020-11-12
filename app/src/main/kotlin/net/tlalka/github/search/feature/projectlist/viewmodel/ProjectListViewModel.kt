package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase.Output.Error
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase.Output.Success

class ProjectListViewModel(
    private val fetchProjectsUseCase: FetchProjectsUseCase
) : ViewModel() {

    private val viewState = MutableLiveData(ProjectListViewState.EMPTY)

    fun getViewState(): LiveData<ProjectListViewState> = viewState

    fun onSearchSelected(query: String) = loading {
        viewState.value = viewState.value?.copy(query = query)
        updateProjectList(query)
    }

    private fun loading(block: suspend () -> Unit) {
        viewState.value = viewState.value?.copy(loading = true)
        viewModelScope.launch {
            block.invoke()
            viewState.value = viewState.value?.copy(loading = false)
        }
    }

    private suspend fun updateProjectList(query: String) {
        when (val result = fetchProjectsUseCase.run(query)) {
            is Success -> viewState.value = viewState.value?.copy(
                projects = result.projects,
                hasError = false
            )
            is Error -> viewState.value = viewState.value?.copy(
                projects = emptyList(),
                hasError = true
            )
        }
    }
}
