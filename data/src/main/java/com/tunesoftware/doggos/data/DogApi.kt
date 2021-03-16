package com.tunesoftware.doggos.data

import retrofit2.http.GET
import retrofit2.http.Query

interface DogApi {

    @GET("breeds")
    suspend fun getBreeds(): List<BreedDto>

    @GET("breeds/search")
    suspend fun getBreedDetails(@Query("q") name: String): List<BreedDetailDto>
}