package com.tunesoftware.doggos.domain

data class BreedDetail(
    val id: Int,
    val name: String,
    val group: String,
    val imageUrl: String,
    val description: String,
    val bredFor: String,
    val weight: IntPair,
    val lifeSpan: IntPair
) {

    data class IntPair(val lower: Int, val upper: Int)
}