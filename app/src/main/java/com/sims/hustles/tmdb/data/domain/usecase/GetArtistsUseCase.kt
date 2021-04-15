package com.sims.hustles.tmdb.data.domain.usecase

import com.sims.hustles.tmdb.data.domain.repository.ArtistRepository
import com.sims.hustles.tmdb.data.models.artists.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}