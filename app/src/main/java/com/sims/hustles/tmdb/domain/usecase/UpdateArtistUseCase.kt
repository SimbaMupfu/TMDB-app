package com.sims.hustles.tmdb.domain.usecase

import com.sims.hustles.tmdb.domain.repository.ArtistRepository
import com.sims.hustles.tmdb.data.models.artists.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}