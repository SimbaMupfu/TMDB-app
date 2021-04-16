package com.sims.hustles.tmdb.data.repository.artist.datasource

import com.sims.hustles.tmdb.data.models.artists.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun clearAll()

    suspend fun saveArtistsToDB(artists: List<Artist>)
}