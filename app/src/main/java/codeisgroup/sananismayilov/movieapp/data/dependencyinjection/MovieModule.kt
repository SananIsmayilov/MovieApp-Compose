package codeisgroup.sananismayilov.movieapp.data.dependencyinjection


import codeisgroup.sananismayilov.movieapp.data.remote.MovieApi
import codeisgroup.sananismayilov.movieapp.data.repository.MovieRepositoryImpl
import codeisgroup.sananismayilov.movieapp.domain.repository.MovieRepository
import codeisgroup.sananismayilov.movieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    @Singleton
    fun provideAPI(): MovieApi {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(MovieApi::class.java)
    }


    @Provides
    @Singleton
    fun provideMovieRepository(movieApi: MovieApi): MovieRepository {
        return MovieRepositoryImpl(movieApi)
    }


}