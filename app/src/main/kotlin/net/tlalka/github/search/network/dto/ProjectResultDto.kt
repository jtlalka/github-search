package net.tlalka.github.search.network.dto

data class ProjectResultDto(
    val items: List<ProjectItemDto> = emptyList()
)