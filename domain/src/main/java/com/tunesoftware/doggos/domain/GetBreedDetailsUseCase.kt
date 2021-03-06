package com.tunesoftware.doggos.domain

interface GetBreedDetailsUseCase {
    suspend operator fun invoke(name: String): BreedDetail?
}

class GetBreedDetailsUseCaseImpl(private val dogRepository: DogRepository): GetBreedDetailsUseCase {
    override suspend fun invoke(name: String): BreedDetail? = dogRepository.getBreedDetails(name)
}