package codeisgroup.sananismayilov.movieapp.domain.repository

import codeisgroup.sananismayilov.movieapp.data.remote.dto.MovieDetailDTO
import codeisgroup.sananismayilov.movieapp.data.remote.dto.MoviesDTO

interface MovieRepository {

    suspend fun getMovies(movieName: String) : MoviesDTO

    suspend fun getMoviesDetail(imdbId : String) : MovieDetailDTO


}