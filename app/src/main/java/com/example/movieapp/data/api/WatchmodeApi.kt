package com.example.movieapp.data.api

import com.example.movieapp.data.model.TvShow
import com.example.movieapp.data.model.response.BaseResponse
import com.example.movieapp.data.model.response.WatchContentListResponse
import com.example.movieapp.data.model.response.WatchContentResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchmodeApi {
    // RxJava endpoints
    @GET("movie/popular")
    fun getMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Single<WatchContentListResponse>

    @GET("tv/popular")
    fun getTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): Single<WatchContentListResponse>


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ): WatchContentResponse


    @GET("tv/{tv_id}")
    suspend fun getTvShowDetails(
        @Path("tv_id") tvId: String,
        @Query("language") language: String = "en-US"
    ): WatchContentResponse

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}