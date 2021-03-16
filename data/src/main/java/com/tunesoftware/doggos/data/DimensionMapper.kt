package com.tunesoftware.doggos.data

import com.tunesoftware.doggos.domain.BreedDetail

class DimensionMapper: Mapper<String, BreedDetail.SizePair> {

    override fun map(input: String): BreedDetail.SizePair {
        val values = input.split(" ")
        val lower = values[0].toFloat()
        val upper = values[2].toFloat()
        return BreedDetail.SizePair(lower, upper)
    }
}