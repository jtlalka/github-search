package net.tlalka.github.search.repository.internal

import net.tlalka.github.search.network.GitHubSearchApi
import net.tlalka.github.search.network.GitHubSearchApiProvider
import net.tlalka.github.search.network.dto.ProjectItemDto
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.internal.mapper.NetworkProjectMapper
import net.tlalka.github.search.repository.internal.mapper.ProjectMapper
import net.tlalka.github.search.repository.model.Project

internal class NetworkProjectRepository(
    private val searchApi: GitHubSearchApi = GitHubSearchApiProvider.searchApi,
    private val projectMapper: ProjectMapper<ProjectItemDto> = NetworkProjectMapper()
) : ProjectRepository {

    override suspend fun fetchProjects(query: String): List<Project> =
        searchApi.getProjects(query).items.map {
            projectMapper.mapToProject(it)
        }
}
