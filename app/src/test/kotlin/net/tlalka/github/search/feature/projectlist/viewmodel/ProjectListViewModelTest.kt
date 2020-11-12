package net.tlalka.github.search.feature.projectlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase
import net.tlalka.github.search.feature.projectlist.domain.FetchProjectsUseCase.Output
import net.tlalka.github.search.repository.model.Project
import net.tlalka.github.search.testunit.TestCoroutineRule
import org.junit.Assert.assertEquals
import org.junit.ClassRule
import org.junit.Test
import org.junit.rules.TestRule
import java.io.IOException

@ExperimentalCoroutinesApi
class ProjectListViewModelTest {

    private val mockFetchProjectsUseCase: FetchProjectsUseCase = mock()

    private val tested = ProjectListViewModel(
        fetchProjectsUseCase = mockFetchProjectsUseCase
    )

    @Test
    fun `updates project list when search action is triggered`() = runBlockingTest {
        given(mockFetchProjectsUseCase.run("test")).willReturn(Output.Success(fakeResult))

        tested.onSearchSelected("test")

        assertEquals(
            ProjectListViewState.EMPTY.copy(
                query = "test",
                projects = fakeResult
            ), tested.getViewState().value
        )
    }

    @Test
    fun `shows error when fetch project use case returns error for search action`() = runBlockingTest {
        given(mockFetchProjectsUseCase.run("test")).willReturn(Output.Error(IOException()))

        tested.onSearchSelected("test")

        assertEquals(
            ProjectListViewState.EMPTY.copy(
                query = "test",
                hasError = true
            ), tested.getViewState().value
        )
    }

    private companion object {

        @ClassRule
        @JvmField
        val instantTestRule: TestRule = InstantTaskExecutorRule()

        @ClassRule
        @JvmField
        val coroutineTestRule: TestRule = TestCoroutineRule()

        val fakeResult: List<Project> = listOf(
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
