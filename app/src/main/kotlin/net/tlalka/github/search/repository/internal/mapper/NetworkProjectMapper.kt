package net.tlalka.github.search.repository.internal.mapper

import net.tlalka.github.search.network.dto.ProjectItemDto
import net.tlalka.github.search.repository.model.Project

internal class NetworkProjectMapper : ProjectMapper<ProjectItemDto> {

    override fun mapToProject(item: ProjectItemDto): Project = with(item) {
        Project(
            id = id,
            name = name.orEmpty(),
            author = owner?.login.orEmpty(),
            size = size.orZero(),
            url = html_url.orEmpty(),
            hasWiki = has_wiki.orFalse()
        )
    }

    private fun Int?.orZero(): Int = this ?: 0

    private fun Boolean?.orFalse(): Boolean = this ?: false
}
