package com.example.movieapp.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.GetContentDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailsViewModel (
    private val getContentDetailsUseCase: GetContentDetailsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    fun loadContent(contentId: String, isMovie: Boolean) {
        _state.value = DetailsState.Loading

        viewModelScope.launch {
            try {
                val content = getContentDetailsUseCase(contentId, isMovie)
                _state.value = DetailsState.Success(content)
            } catch (e: Exception) {
                _state.value = DetailsState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }
}