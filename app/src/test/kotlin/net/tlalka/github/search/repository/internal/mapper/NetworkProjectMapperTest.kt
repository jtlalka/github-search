package net.tlalka.github.search.repository.internal.mapper

import net.tlalka.github.search.network.dto.ProjectItemDto
import net.tlalka.github.search.network.dto.ProjectOwnerDto
import net.tlalka.github.search.repository.model.Project
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkProjectMapperTest {

    private val tested: ProjectMapper<ProjectItemDto> = NetworkProjectMapper()

    @Test
    fun `converts network DTO to Project data model`() {
        val given = ProjectItemDto(
            id = 1,
            name = "Name",
            size = 124,
            html_url = "http://github.test.com",
            has_wiki = true,
            owner = ProjectOwnerDto("Login")
        )

        val result: Project = tested.mapToProject(given)

        assertEquals(
            Project(
                id = 1,
                name = "Name",
                author = "Login",
                size = 124,
                url = "http://github.test.com",
                hasWiki = true
            ),
            result
        )
    }

    @Test
    fun `converts empty network DTO to Project data model`() {
        val given = ProjectItemDto(
            id = 1,
            name = "",
            size = 0,
            html_url = "",
            has_wiki = false,
            owner = ProjectOwnerDto("")
        )

        val result: Project = tested.mapToProject(given)

        assertEquals(
            Project(
                id = 1,
                name = "",
                author = "",
                size = 0,
                url = "",
                hasWiki = false
            ),
            result
        )
    }

    @Test
    fun `converts undefined network DTO to Project data model`() {
        val given = ProjectItemDto(
            id = 1,
            name = null,
            size = null,
            html_url = null,
            has_wiki = null,
            owner = null
        )

        val result: Project = tested.mapToProject(given)

        assertEquals(
            Project(
                id = 1,
                name = "",
                author = "",
                size = 0,
                url = "",
                hasWiki = false
            ),
            result
        )
    }
}