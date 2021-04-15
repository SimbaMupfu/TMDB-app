package com.sims.hustles.tmdb.data.repository.movie.datasource

import com.sims.hustles.tmdb.data.models.movies.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}