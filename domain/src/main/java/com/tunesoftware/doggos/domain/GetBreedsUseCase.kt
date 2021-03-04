package com.tunesoftware.doggos.domain

interface GetBreedsUseCase {
    suspend operator fun invoke(): List<Breed>
}

class GetBreedsUseCaseImpl(private val dogRepository: DogRepository): GetBreedsUseCase {
    override suspend fun invoke(): List<Breed> = dogRepository.getBreeds()
}