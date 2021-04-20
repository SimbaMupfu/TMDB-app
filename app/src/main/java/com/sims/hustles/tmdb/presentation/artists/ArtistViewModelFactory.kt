package com.sims.hustles.tmdb.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sims.hustles.tmdb.domain.usecase.GetArtistsUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistUseCase) as T
    }
}