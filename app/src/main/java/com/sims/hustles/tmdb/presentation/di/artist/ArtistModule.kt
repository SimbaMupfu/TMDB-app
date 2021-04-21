package com.sims.hustles.tmdb.presentation.di.artist

import com.sims.hustles.tmdb.domain.usecase.GetArtistsUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateArtistUseCase
import com.sims.hustles.tmdb.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCase,
    updateArtistUseCase: UpdateArtistUseCase): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistUseCase)
    }
}