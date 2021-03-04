package com.tunesoftware.doggos.domain

interface GetBreedDetailsUseCase {
    suspend operator fun invoke(breedId: Int): BreedDetail
}

class GetBreedDetailsUseCaseImpl(private val dogRepository: DogRepository): GetBreedDetailsUseCase {
    override suspend fun invoke(breedId: Int): BreedDetail = dogRepository.getBreedDetails(breedId)
}