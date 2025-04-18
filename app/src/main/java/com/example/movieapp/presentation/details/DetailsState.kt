package com.example.movieapp.presentation.details

import com.example.movieapp.data.model.WatchContent

sealed class DetailsState {
    data object Loading : DetailsState()
    data class Success(val content: WatchContent) : DetailsState()
    data class Error(val message: String) : DetailsState()
}