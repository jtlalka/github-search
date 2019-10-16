package net.tlalka.github.search.network

import net.tlalka.github.search.network.dto.ProjectResultDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GitHubSearchApi {

    @GET("search/repositories")
    suspend fun getProjects(
        @Query("q") query: String,
        @Query("page") page: String = "0"
    ): ProjectResultDto

    companion object Setup {

        const val BASE_URL = "https://api.github.com/"

        const val REQUEST_TIMEOUT_MS = 9000L
    }
}