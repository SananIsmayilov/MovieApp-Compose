package codeisgroup.sananismayilov.movieapp.presentation.moviedetailscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import codeisgroup.sananismayilov.movieapp.domain.model.MoviesDetailModel
import codeisgroup.sananismayilov.movieapp.domain.usecases.moviesdetailusecase.MoviesDetailUseCase
import codeisgroup.sananismayilov.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(val getMoviesDetailUseCase: MoviesDetailUseCase) :
    ViewModel() {
    var job: Job? = null

    private val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state: State<MovieDetailState> = _state

    fun getMovieDetail(imdbId: String) {
        job = getMoviesDetailUseCase.executegetMovieDetail(imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movieDetailModel = it.data)
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message!!)
                }
            }
        }.launchIn(viewModelScope)
    }


}