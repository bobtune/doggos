package com.tunesoftware.doggos.domain

data class BreedDetail(
    val id: Int,
    val name: String,
    val group: String,
    val temperament: String,
    val bredFor: String,
    val weight: SizePair,
    val lifeSpan: SizePair
) {

    data class SizePair(val lower: Float, val upper: Float)
}