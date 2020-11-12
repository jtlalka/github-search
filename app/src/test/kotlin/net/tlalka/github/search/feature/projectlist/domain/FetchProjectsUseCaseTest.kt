package net.tlalka.github.search.feature.projectlist.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase.Output.Error
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase.Output.Success
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.model.Project
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class FetchProjectsUseCaseTest {

    private val mockRepository: ProjectRepository = mock()

    private val tested = FetchProjectsUseCase(mockRepository)

    @Test
    fun `returns project list when query is correct`() = runBlockingTest {
        given(mockRepository.fetchProjects(eq(fakeQuery))).willReturn(fakeResults)

        val result = tested.run(fakeQuery)

        assertEquals(Success(fakeResults), result)
    }

    @Test
    fun `returns empty project list when query is empty`() = runBlockingTest {
        given(mockRepository.fetchProjects(eq(""))).willReturn(emptyList())

        val result = tested.run("")

        assertEquals(Success(emptyList()), result)
    }

    @Test
    fun `returns error when repository thrown an exception`() = runBlockingTest {
        val givenException = NullPointerException()
        given(mockRepository.fetchProjects(any())).willThrow(givenException)

        val result = tested.run("test")

        assertEquals(Error(givenException), result)
    }

    @Test
    fun `verifies single repository usages`() = runBlockingTest {
        given(mockRepository.fetchProjects(any())).willReturn(emptyList())

        tested.run(fakeQuery)

        verify(mockRepository).fetchProjects(eq(fakeQuery))
    }

    private companion object {

        const val fakeQuery: String = "query"

        val fakeResults: List<Project> = listOf(
            Project(
                id = 0,
                name = "Name",
                author = "Author",
                size = 100,
                url = "",
                hasWiki = false
            )
        )
    }
}
