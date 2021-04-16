package com.sims.hustles.tmdb.data.repository.tvshow.datasource

import com.sims.hustles.tmdb.data.models.tvshows.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}