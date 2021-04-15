package com.sims.hustles.tmdb.data.repository.movie.datasource

import com.sims.hustles.tmdb.data.models.movies.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>

    suspend fun saveMoviesToDB(movies: List<Movie>)

    suspend fun clearAll()
}