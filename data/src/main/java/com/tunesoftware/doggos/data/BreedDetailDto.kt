package com.tunesoftware.doggos.data

data class BreedDetailDto(
    val id: Int,
    val name: String,
    val breedGroup: String?,
    val image: DogImage,
    val temperament: String,
    val bredFor: String,
    val weight: Dimension,
    val lifeSpan: String
) {
    data class Dimension(val imperial: String, val metric: String)
}
