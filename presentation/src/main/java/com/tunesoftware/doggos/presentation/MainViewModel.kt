package com.tunesoftware.doggos.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunesoftware.doggos.domain.GetBreedsUseCaseImpl
import kotlinx.coroutines.launch

class MainViewModel(private val getBreeds: GetBreedsUseCaseImpl): ViewModel() {

    init {
        viewModelScope.launch {
            val breeds = getBreeds()
            Log.d("MainViewModel", "getBreeds(): $breeds")
        }
    }
}