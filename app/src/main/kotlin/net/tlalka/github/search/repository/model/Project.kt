package net.tlalka.github.search.repository.model

data class Project(
    val id: Int,
    val name: String,
    val author: String,
    val size: Int,
    val url: String,
    val hasWiki: Boolean
)
