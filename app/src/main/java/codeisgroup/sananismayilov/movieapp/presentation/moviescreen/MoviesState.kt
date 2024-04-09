package codeisgroup.sananismayilov.movieapp.presentation.moviescreen

import codeisgroup.sananismayilov.movieapp.domain.model.MovieModel

data class MoviesState(
    val movieList: List<MovieModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val movieName: String = "Batman"
)
