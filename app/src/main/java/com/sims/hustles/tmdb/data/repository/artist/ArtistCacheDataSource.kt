package com.sims.hustles.tmdb.data.repository.artist

import com.sims.hustles.tmdb.data.models.artists.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(artists: List<Artist>)
}