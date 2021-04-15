package com.sims.hustles.tmdb.data.repository.movie.datasourceImpl

import com.sims.hustles.tmdb.data.api.TMDBService
import com.sims.hustles.tmdb.data.models.movies.MovieList
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
private val apiKey: String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}