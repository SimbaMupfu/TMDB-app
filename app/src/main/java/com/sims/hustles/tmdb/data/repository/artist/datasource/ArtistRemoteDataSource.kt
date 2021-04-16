package com.sims.hustles.tmdb.data.repository.artist.datasource

import com.sims.hustles.tmdb.data.models.artists.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}