package codeisgroup.sananismayilov.movieapp.data.remote

import codeisgroup.sananismayilov.movieapp.data.remote.dto.MovieDetailDTO
import codeisgroup.sananismayilov.movieapp.data.remote.dto.MoviesDTO
import codeisgroup.sananismayilov.movieapp.util.Constants.APIKEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    suspend fun getMovies(
        @Query("s") movieName: String,
        @Query("apikey") apikey: String = APIKEY,
    ): MoviesDTO

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apikey: String = APIKEY,
    ): MovieDetailDTO
}