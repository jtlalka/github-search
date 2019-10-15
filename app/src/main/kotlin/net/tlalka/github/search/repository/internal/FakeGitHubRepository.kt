package net.tlalka.github.search.repository.internal

import net.tlalka.github.search.repository.GitHubRepository
import net.tlalka.github.search.repository.model.Project

internal class FakeGitHubRepository : GitHubRepository {

    //TODO: Add network result
    override fun findProjects(query: String): List<Project> = listOf(
        Project(
            name = query + "01",
            author = "Author",
            size = 100
        ),
        Project(
            name = query + "02",
            author = "Author",
            size = 100
        ),
        Project(
            name = query + "03",
            author = "Author",
            size = 100
        )
    )
}