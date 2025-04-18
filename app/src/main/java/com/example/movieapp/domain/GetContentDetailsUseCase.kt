package com.example.movieapp.domain

import com.example.movieapp.data.model.WatchContent
import com.example.movieapp.data.repository.WatchRepository
import javax.inject.Inject

class GetContentDetailsUseCase(
    private val repository: WatchRepository
) {
    suspend operator fun invoke(contentId: String, isMovie: Boolean): WatchContent {
        return repository.getContentDetails(contentId, isMovie)
    }
}