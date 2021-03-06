package com.tunesoftware.doggos.domain

interface DogRepository {

    suspend fun getBreeds(): List<Breed>

    suspend fun getBreedDetails(name: String): BreedDetail?
}