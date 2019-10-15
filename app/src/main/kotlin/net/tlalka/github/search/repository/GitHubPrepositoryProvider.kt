package net.tlalka.github.search.repository

import net.tlalka.github.search.repository.internal.FakeGitHubRepository

object GitHubPrepositoryProvider {

    val gitHubRepository: GitHubRepository
        get() = FakeGitHubRepository()
}