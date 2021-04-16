package com.sims.hustles.tmdb.data.repository.tvshow.datasource

import com.sims.hustles.tmdb.data.models.tvshows.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}