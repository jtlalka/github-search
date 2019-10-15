package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.tlalka.github.search.feature.projectlist.domain.FindProjectsUseCase

class ProjectListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ProjectListViewModel(FindProjectsUseCase()) as T
}