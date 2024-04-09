package codeisgroup.sananismayilov.movieapp.data.remote.dto

import codeisgroup.sananismayilov.movieapp.domain.model.MovieModel

data class MoviesDTO(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDTO.toMoviesModel(): List<MovieModel> {
    val movies = Search.map {
        MovieModel(it.Poster, it.Title, it.imdbID)
    }
    return movies


}
