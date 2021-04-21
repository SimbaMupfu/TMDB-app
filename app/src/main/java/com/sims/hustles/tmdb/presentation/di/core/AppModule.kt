package com.sims.hustles.tmdb.presentation.di.core

import android.content.Context
import com.sims.hustles.tmdb.presentation.di.artist.ArtistSubComponent
import com.sims.hustles.tmdb.presentation.di.movie.MovieSubComponent
import com.sims.hustles.tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}