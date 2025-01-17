package net.tlalka.github.search.repository

import net.tlalka.github.search.repository.model.Project

interface ProjectRepository {

    suspend fun fetchProjects(query: String): List<Project>
}
