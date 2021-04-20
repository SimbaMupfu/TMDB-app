package com.sims.hustles.tmdb.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sims.hustles.tmdb.domain.usecase.GetArtistsUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistUseCase.execute()
        emit(artistsList)
    }
}