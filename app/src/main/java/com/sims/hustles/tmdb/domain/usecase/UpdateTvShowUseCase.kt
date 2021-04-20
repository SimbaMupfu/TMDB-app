package com.sims.hustles.tmdb.domain.usecase

import com.sims.hustles.tmdb.domain.repository.TvShowRepository
import com.sims.hustles.tmdb.data.models.tvshows.TvShow

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShow()
}