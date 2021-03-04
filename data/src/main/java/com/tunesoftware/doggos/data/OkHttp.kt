package com.tunesoftware.doggos.data

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor(BuildConfig.API_KEY))
        .retryOnConnectionFailure(true)
        .build()
}

class BasicAuthInterceptor(private val apiKey: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().header("X-API-KEY", apiKey).build()
        return chain.proceed(request)
    }
}