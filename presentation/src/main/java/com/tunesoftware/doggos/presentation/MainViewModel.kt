package com.tunesoftware.doggos.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunesoftware.doggos.domain.GetBreedDetailsUseCase
import com.tunesoftware.doggos.domain.GetBreedsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getBreeds: GetBreedsUseCase,
    private val getBreedDetailsUseCase: GetBreedDetailsUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            val breeds = getBreeds()
            Log.d("MainViewModel", "getBreeds(): $breeds")
        }
    }
}