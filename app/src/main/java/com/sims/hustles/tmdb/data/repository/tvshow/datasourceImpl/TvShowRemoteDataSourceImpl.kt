package com.sims.hustles.tmdb.data.repository.tvshow.datasourceImpl

import com.sims.hustles.tmdb.data.api.TMDBService
import com.sims.hustles.tmdb.data.models.tvshows.TvShowList
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                 private val apiKey: String): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}