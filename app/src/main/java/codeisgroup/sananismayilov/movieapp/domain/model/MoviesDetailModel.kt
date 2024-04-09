package codeisgroup.sananismayilov.movieapp.domain.model

import codeisgroup.sananismayilov.movieapp.data.remote.dto.Rating

data class MoviesDetailModel(
    val Actors: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Released: String,
    val title: String,
    val Year: String,
)
