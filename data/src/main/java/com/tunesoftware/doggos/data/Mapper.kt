package com.tunesoftware.doggos.data

interface Mapper<I, O> {

    fun map(input: I): O
}