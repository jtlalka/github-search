package net.tlalka.github.search.feature.projectlist.domain

import net.tlalka.github.search.repository.GitHubPrepositoryProvider
import net.tlalka.github.search.repository.GitHubRepository
import net.tlalka.github.search.repository.model.Project

class FindProjectsUseCase(
    private val gitHubRepository: GitHubRepository = GitHubPrepositoryProvider.gitHubRepository
) {

    fun findProjects(query: String): List<Project> =
        gitHubRepository.findProjects(query)
}