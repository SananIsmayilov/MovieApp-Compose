package codeisgroup.sananismayilov.movieapp.presentation.moviescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import codeisgroup.sananismayilov.movieapp.domain.model.MovieModel
import codeisgroup.sananismayilov.movieapp.domain.usecases.moviesusecase.MoviesUseCase
import codeisgroup.sananismayilov.movieapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val getMoviesUseCase: MoviesUseCase) : ViewModel() {

    var job: Job? = null

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state: State<MoviesState> = _state

    init {
        getMovies(_state.value.movieName)
    }
    fun getMovies(movieName: String) {
        job?.cancel()

        job = getMoviesUseCase.executegetMovies(movieName).onEach {

            when (it) {
                is Resource.Success -> {
                    _state.value = MoviesState(movieList = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        MoviesState(error = it.message ?: "Gözlənilməyən cəta baş verdi!")
                }

                is Resource.Loading -> {
                    _state.value = MoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}