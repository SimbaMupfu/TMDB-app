package com.sims.hustles.tmdb.domain.repository

import com.sims.hustles.tmdb.data.models.tvshows.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShow(): List<TvShow>?
}