package com.tunesoftware.doggos.data

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

inline fun <reified T> createRetrofit(okHttpClient: OkHttpClient, converter: Converter.Factory, url: String): T {
    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(url)
        .addConverterFactory(converter)
        .build()

    return retrofit.create(T::class.java)
}