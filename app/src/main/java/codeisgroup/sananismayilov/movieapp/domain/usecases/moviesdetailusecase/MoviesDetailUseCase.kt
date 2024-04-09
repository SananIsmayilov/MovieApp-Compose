package codeisgroup.sananismayilov.movieapp.domain.usecases.moviesdetailusecase

import codeisgroup.sananismayilov.movieapp.data.remote.dto.toMoviesDetailModel
import codeisgroup.sananismayilov.movieapp.domain.model.MoviesDetailModel
import codeisgroup.sananismayilov.movieapp.domain.repository.MovieRepository
import codeisgroup.sananismayilov.movieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesDetailUseCase @Inject constructor(val movieRepository: MovieRepository) {

    fun executegetMovieDetail(imdbId: String): Flow<Resource<MoviesDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = movieRepository.getMoviesDetail(imdbId)
            emit(Resource.Success(response.toMoviesDetailModel()))

        } catch (e: Exception) {
            emit(Resource.Error(e.toString(), null))
        }
    }
}