package com.sims.hustles.tmdb.data.domain.repository

import com.sims.hustles.tmdb.data.models.movies.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}