package codeisgroup.sananismayilov.movieapp.domain.usecases.moviesusecase

import codeisgroup.sananismayilov.movieapp.data.remote.dto.MoviesDTO
import codeisgroup.sananismayilov.movieapp.data.remote.dto.toMoviesModel
import codeisgroup.sananismayilov.movieapp.domain.model.MovieModel
import codeisgroup.sananismayilov.movieapp.domain.repository.MovieRepository
import codeisgroup.sananismayilov.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(val movieRepository: MovieRepository) {

    fun executegetMovies(movieName: String): Flow<Resource<List<MovieModel>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = movieRepository.getMovies(movieName)
            if (movies.Response == "True") {
                emit(Resource.Success(movies.toMoviesModel()))
            } else {
                emit(Resource.Error("No movies", null))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.toString(), null))
        }
    }


}