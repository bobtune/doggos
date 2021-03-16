package com.tunesoftware.doggos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunesoftware.doggos.domain.Breed
import com.tunesoftware.doggos.domain.BreedDetail
import com.tunesoftware.doggos.domain.GetBreedDetailsUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val getBreedDetailsUseCase: GetBreedDetailsUseCase): ViewModel() {

    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> = _state

    fun getDetails(breedName: String) {
        viewModelScope.launch {
            _state.value = when (val detail = getBreedDetailsUseCase(breedName)) {
                null -> DetailState.BreedNotFound
                else -> DetailState.BreedDetails(detail)
            }
        }
    }

    sealed class DetailState {
        data class BreedDetails(val breedDetail: BreedDetail): DetailState()
        object BreedNotFound: DetailState()
    }
}