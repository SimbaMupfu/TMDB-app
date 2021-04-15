package com.sims.hustles.tmdb.data.domain.repository

import com.sims.hustles.tmdb.data.models.artists.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtist(): List<Artist>?
}