package net.tlalka.github.search.repository

import net.tlalka.github.search.repository.internal.NetworkProjectRepository

object ProjectRepositoryProvider {

    val projectRepository: ProjectRepository
        get() = NetworkProjectRepository()
}