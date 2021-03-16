package com.tunesoftware.doggos.presentation

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.domain.GetBreedsUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getBreeds: GetBreedsUseCase): ViewModel() {

    private val _state = MutableLiveData<MainState>()
    val state: LiveData<MainState> = _state

    init {
        viewModelScope.launch {
            _state.value = MainState.BreedsList(getBreeds())
        }
    }

    fun breedClicked(breed: Breed, view: View) {
        _state.value = MainState.NavigateToDetail(breed, view)
    }

    sealed class MainState {
        data class BreedsList(val breeds: List<Breed>): MainState()
        data class NavigateToDetail(val  breed: Breed, val view: View): MainState()
    }
}