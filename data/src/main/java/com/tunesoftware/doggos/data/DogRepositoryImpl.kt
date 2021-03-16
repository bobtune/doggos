package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.domain.BreedDetail
import com.tunesoftware.doggos.domain.DogRepository

class DogRepositoryImpl(
    private val dogApi: DogApi,
    private val breedMapper: Mapper<BreedDto, Breed>,
    private val breedDetailMapper: Mapper<BreedDetailDto, BreedDetail>
): DogRepository {

    override suspend fun getBreeds(): List<Breed> {
        return dogApi.getBreeds().map { breedDto ->
            breedMapper.map(breedDto)
        }
    }

    override suspend fun getBreedDetails(name: String): BreedDetail? {
        return dogApi.getBreedDetails(name).getOrNull(0)?.let { breedDetailDto ->
            breedDetailMapper.map(breedDetailDto)
        }
    }
}