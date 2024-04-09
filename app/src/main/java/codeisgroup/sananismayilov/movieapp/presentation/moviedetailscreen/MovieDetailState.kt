package codeisgroup.sananismayilov.movieapp.presentation.moviedetailscreen

import codeisgroup.sananismayilov.movieapp.domain.model.MoviesDetailModel

data class MovieDetailState(
    var isLoading: Boolean = false,
    var error: String = "",
    var movieDetailModel: MoviesDetailModel? = null,

    )