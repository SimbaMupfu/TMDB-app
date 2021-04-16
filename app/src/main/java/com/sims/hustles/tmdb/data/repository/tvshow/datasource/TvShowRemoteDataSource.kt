package com.sims.hustles.tmdb.data.repository.tvshow.datasource

import com.sims.hustles.tmdb.data.models.tvshows.TvShow
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShow>
}