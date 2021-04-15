package com.sims.hustles.tmdb.data.repository.movie.datasource

import com.sims.hustles.tmdb.data.models.movies.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)
}