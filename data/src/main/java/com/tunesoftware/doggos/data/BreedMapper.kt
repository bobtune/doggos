package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.Breed

class BreedMapper: Mapper<BreedDto, Breed> {

    override fun map(input: BreedDto): Breed =
        Breed(input.id, input.name, input.breedGroup ?: "", input.image.url)
}