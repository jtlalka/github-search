package net.tlalka.github.search.repository.internal.mapper

import net.tlalka.github.search.repository.model.Project

internal interface ProjectMapper<T> {

    fun mapToProject(item: T): Project
}
