package net.tlalka.github.search.repository.internal

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import net.tlalka.github.search.network.GitHubSearchApi
import net.tlalka.github.search.network.dto.ProjectItemDto
import net.tlalka.github.search.network.dto.ProjectOwnerDto
import net.tlalka.github.search.network.dto.ProjectResultDto
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.internal.mapper.ProjectMapper
import net.tlalka.github.search.repository.model.Project
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkProjectRepositoryTest {

    private val mockSearchApi: GitHubSearchApi = mock()
    private val mockProjectMapper: ProjectMapper<ProjectItemDto> = mock()

    private val tested: ProjectRepository = NetworkProjectRepository(
        searchApi = mockSearchApi,
        projectMapper = mockProjectMapper
    )

    @Test
    fun `returns project when network results single project result DTO`() = runBlocking {
        val singleNetworkResult = ProjectResultDto(listOf(fakeNetworkItem))
        given(mockSearchApi.getProjects(any(), any())).willReturn(singleNetworkResult)
        given(mockProjectMapper.mapToProject(fakeNetworkItem)).willReturn(fakeMappingResult)

        val result = tested.findProjects("query")

        assertEquals(listOf(fakeMappingResult), result)
    }

    @Test
    fun `returns empty list of projects when network result is empty`() = runBlocking {
        given(mockSearchApi.getProjects(any(), any())).willReturn(ProjectResultDto())

        val result = tested.findProjects("query")

        assertEquals(emptyList<Project>(), result)
    }

    companion object {

        private val fakeNetworkItem: ProjectItemDto = ProjectItemDto(
            id = 1,
            name = "Name",
            size = 124,
            html_url = "http://github.test.com",
            has_wiki = true,
            owner = ProjectOwnerDto("Login")
        )

        private val fakeMappingResult: Project = Project(
            id = 1,
            name = "Name",
            author = "Login",
            size = 124,
            url = "http://github.test.com",
            hasWiki = true
        )
    }
}