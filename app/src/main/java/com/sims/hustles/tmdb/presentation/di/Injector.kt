package com.sims.hustles.tmdb.presentation.di

import com.sims.hustles.tmdb.presentation.di.artist.ArtistSubComponent
import com.sims.hustles.tmdb.presentation.di.movie.MovieSubComponent
import com.sims.hustles.tmdb.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}