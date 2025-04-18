package com.example.movieapp.data.model.response

data class BaseResponse<T>(
    val page: Int,
    val results: List<T>,
    val total_pages: Int,
    val total_results: Int
)