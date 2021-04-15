package com.sims.hustles.tmdb.data.domain.usecase

import com.sims.hustles.tmdb.data.domain.repository.MovieRepository
import com.sims.hustles.tmdb.data.models.movies.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}