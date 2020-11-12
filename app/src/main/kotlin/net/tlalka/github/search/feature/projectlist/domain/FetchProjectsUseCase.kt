package net.tlalka.github.search.feature.projectlist.domain

import net.tlalka.github.search.platform.UseCase
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.ProjectRepositoryProvider
import net.tlalka.github.search.repository.model.Project

class FetchProjectsUseCase(
    private val projectRepository: ProjectRepository = ProjectRepositoryProvider.projectRepository
) : UseCase<String, FetchProjectsUseCase.Output> {

    override suspend fun run(input: String): Output = try {
        Output.Success(projectRepository.fetchProjects(input))
    } catch (ex: Exception) {
        Output.Error(ex)
    }

    sealed class Output {
        data class Success(val projects: List<Project>) : Output()
        data class Error(val exception: Exception) : Output()
    }
}
