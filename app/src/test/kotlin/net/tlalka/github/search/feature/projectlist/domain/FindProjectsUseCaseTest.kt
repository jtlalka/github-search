package net.tlalka.github.search.feature.projectlist.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import net.tlalka.github.search.repository.ProjectRepository
import net.tlalka.github.search.repository.model.Project
import org.junit.Assert.assertEquals
import org.junit.Test

class FindProjectsUseCaseTest {

    private val mockRepository: ProjectRepository = mock()

    private val tested = FindProjectsUseCase(mockRepository)

    @Test
    fun `returns data for defined query`() = runBlocking {
        given(mockRepository.findProjects(eq(fakeQuery))).willReturn(fakeResults)

        val result = tested.findProjects(fakeQuery)

        assertEquals(fakeResults, result.first)
    }

    @Test
    fun `returns empty list for empty query`() = runBlocking {
        given(mockRepository.findProjects(eq(""))).willReturn(emptyList())

        val result = runBlocking { tested.findProjects("") }

        assertEquals(emptyList<Project>(), result.first)
    }

    @Test
    fun `verifies single repository usages`() = runBlocking {
        given(mockRepository.findProjects(any())).willReturn(emptyList())

        tested.findProjects(fakeQuery)

        verify(mockRepository).findProjects(eq(fakeQuery))
        Unit
    }

    companion object {

        private const val fakeQuery: String = "query"

        private val fakeResults: List<Project> = listOf(
            Project(
                id = 0,
                name = "Name",
                author = "Author",
                size = 100
            )
        )
    }
}