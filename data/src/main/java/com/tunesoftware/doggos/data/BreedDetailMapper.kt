package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.BreedDetail

class BreedDetailMapper(
    private val dimensionMapper: Mapper<String, BreedDetail.SizePair>
): Mapper<BreedDetailDto, BreedDetail> {

    override fun map(input: BreedDetailDto): BreedDetail =
        BreedDetail(
            input.id,
            input.name,
            input.breedGroup ?: "",
            input.temperament,
            input.bredFor,
            dimensionMapper.map(input.weight.metric),
            dimensionMapper.map(input.lifeSpan)
        )
}