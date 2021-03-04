package com.tunesoftware.doggos.domain

interface DogRepository {

    suspend fun getBreeds(): List<Breed>

    fun getBreedDetails(breedId: Int): BreedDetail
}