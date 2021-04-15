package com.sims.hustles.tmdb.data.repository.movie.datasourceImpl

import com.sims.hustles.tmdb.data.models.movies.Movie
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}