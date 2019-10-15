package net.tlalka.github.search.repository

import net.tlalka.github.search.repository.model.Project

interface GitHubRepository {

    fun findProjects(query: String): List<Project>
}