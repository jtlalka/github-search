package net.tlalka.github.search.repository.internal

import net.tlalka.github.search.network.GitHubSearchApi
import net.tlalka.github.search.network.GitHubSearchApiProvider
import net.tlalka.github.search.network.dto.ProjectResultDto
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.model.Project

internal class NetworkProjectRepository(
    private val searchApi: GitHubSearchApi = GitHubSearchApiProvider().getApi()
) : ProjectRepository {

    override suspend fun findProjects(query: String): List<Project> =
        searchApi.getProjects(query).toProjectList()

    private fun ProjectResultDto.toProjectList(): List<Project> = this.items.map {
        Project(
            id = it.id,
            name = it.name.orEmpty(),
            author = it.owner?.login.orEmpty(),
            size = it.size.orZero(),
            url = it.html_url.orEmpty(),
            hasWiki = it.has_wiki.orFalse()
        )
    }

    private fun String?.orEmpty(): String = this ?: ""

    private fun Int?.orZero(): Int = this ?: 0

    private fun Boolean?.orFalse(): Boolean = this ?: false
}