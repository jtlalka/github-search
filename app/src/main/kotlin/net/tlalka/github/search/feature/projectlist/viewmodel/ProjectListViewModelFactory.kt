package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase

// TODO Use DI for VM Factory
class ProjectListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ProjectListViewModel(FetchProjectsUseCase()) as T
}
