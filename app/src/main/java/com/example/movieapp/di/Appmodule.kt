package com.example.movieapp.di
import com.example.movieapp.WatchApplication
import com.example.movieapp.domain.GetContentDetailsUseCase
import com.example.movieapp.domain.GetMoviesAndTvShowsUseCase

import com.example.movieapp.presentation.details.DetailsViewModel
import com.example.movieapp.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Application
    single { WatchApplication() }

    // UseCases
    factory { GetMoviesAndTvShowsUseCase(get()) }
    factory { GetContentDetailsUseCase(get()) }

    // ViewModels
    viewModel { HomeViewModel(get()) }  // Only passing GetMoviesAndTvShowsUseCase
    viewModel { DetailsViewModel(get()) }
}