package net.tlalka.github.search.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

internal object HttpNetworkClient {

    val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .readTimeout(GitHubSearchApi.REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .build()
    }

    private fun getLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor { message -> Log.d("Network", message) }.apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
}