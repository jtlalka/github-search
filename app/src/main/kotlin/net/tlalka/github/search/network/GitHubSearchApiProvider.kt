package net.tlalka.github.search.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object GitHubSearchApiProvider {

    val searchApi: GitHubSearchApi by lazy {
        Retrofit.Builder()
            .baseUrl(GitHubSearchApi.BASE_URL)
            .client(HttpNetworkClient.httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubSearchApi::class.java)
    }
}