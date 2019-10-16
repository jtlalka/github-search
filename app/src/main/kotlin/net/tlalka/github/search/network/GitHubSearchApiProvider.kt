package net.tlalka.github.search.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class GitHubSearchApiProvider {

    fun getApi(): GitHubSearchApi = Retrofit.Builder()
        .baseUrl(GitHubSearchApi.BASE_URL)
        .client(HttpNetworkClient.httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubSearchApi::class.java)
}