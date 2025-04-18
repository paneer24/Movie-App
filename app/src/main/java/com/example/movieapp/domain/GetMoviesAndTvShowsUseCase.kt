package com.example.movieapp.domain

import com.example.movieapp.data.model.WatchContent
import com.example.movieapp.data.repository.WatchRepository
import io.reactivex.rxjava3.core.Single

class GetMoviesAndTvShowsUseCase(
    private val repository: WatchRepository
) {
    operator fun invoke(): Single<Pair<List<WatchContent>, List<WatchContent>>> {
        return repository.getMoviesAndTvShows()
    }
}