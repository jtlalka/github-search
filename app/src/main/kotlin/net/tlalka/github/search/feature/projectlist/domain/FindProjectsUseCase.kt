package net.tlalka.github.search.feature.projectlist.domain

import android.util.Log
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.ProjectRepositoryProvider
import net.tlalka.github.search.repository.model.Project

typealias FindResult = Pair<List<Project>, Boolean>

class FindProjectsUseCase(
    private val projectRepository: ProjectRepository = ProjectRepositoryProvider.projectRepository
) {

    suspend fun findProjects(query: String): FindResult = try {
        projectRepository.findProjects(query) to false
    } catch (e: Exception) {
        Log.e("FindProjectsUseCase", e.message, e)
        emptyList<Project>() to true
    }
}