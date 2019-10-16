package net.tlalka.github.search.network.dto

data class ProjectItemDto(
    val id: Int,
    val name: String?,
    val size: Int?,
    val html_url: String?,
    val has_wiki: Boolean?,
    val owner: ProjectOwnerDto?
)