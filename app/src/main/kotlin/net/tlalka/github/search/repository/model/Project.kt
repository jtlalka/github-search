package net.tlalka.github.search.repository.model

data class Project(
    val id: Int,
    val name: String = "",
    val author: String = "",
    val size: Int = 0,
    val url: String = "",
    val hasWiki: Boolean = false
)