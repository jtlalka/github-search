package net.tlalka.github.search.repository

import net.tlalka.github.search.repository.internal.FakeProjectRepository

object ProjectRepositoryProvider {

    val projectRepository: ProjectRepository
        get() = FakeProjectRepository()
}