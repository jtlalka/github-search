package net.tlalka.github.search.feature.projectlist.domain

import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.ProjectRepositoryProvider
import net.tlalka.github.search.repository.model.Project

class FindProjectsUseCase(
    private val projectRepository: ProjectRepository = ProjectRepositoryProvider.projectRepository
) {

    suspend fun findProjects(query: String): List<Project> =
        projectRepository.findProjects(query)
}