package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.domain.BreedDetail
import com.tunesoftware.doggos.domain.DogRepository

class DogRepositoryImpl(private val dogApi: DogApi): DogRepository {

    override suspend fun getBreeds(): List<Breed> {
        return dogApi.getBreeds().map {
            Breed(it.id, it.name, it.breedGroup ?: "", it.image.url)
        }
    }

    override fun getBreedDetails(breedId: Int): BreedDetail {
        return BreedDetail(1, "", "", "", "", "", BreedDetail.IntPair(1, 2), BreedDetail.IntPair(1, 2))
    }
}