package codeisgroup.sananismayilov.movieapp.data.repository

import codeisgroup.sananismayilov.movieapp.data.remote.MovieApi
import codeisgroup.sananismayilov.movieapp.data.remote.dto.MovieDetailDTO
import codeisgroup.sananismayilov.movieapp.data.remote.dto.MoviesDTO
import codeisgroup.sananismayilov.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val movieApi: MovieApi) : MovieRepository {
    override suspend fun getMovies(movieName: String): MoviesDTO {
        return movieApi.getMovies(movieName = movieName)
    }

    override suspend fun getMoviesDetail(imdbId: String): MovieDetailDTO {
        return movieApi.getMovieDetail(imdbId = imdbId)
    }
}