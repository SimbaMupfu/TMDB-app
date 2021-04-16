package com.sims.hustles.tmdb.data.repository.tvshow.datasource

import com.sims.hustles.tmdb.data.models.tvshows.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)

    suspend fun clearAll()
}