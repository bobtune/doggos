package com.tunesoftware.doggos.data

import retrofit2.http.GET

interface DogApi {

    @GET("breeds")
    suspend fun getBreeds(): List<BreedDto>
}