package com.sims.hustles.tmdb.data.repository.artist.datasourceImpl

import com.sims.hustles.tmdb.data.api.TMDBService
import com.sims.hustles.tmdb.data.models.artists.ArtistList
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl( private val tmdbService: TMDBService, private val apiKey: String): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}