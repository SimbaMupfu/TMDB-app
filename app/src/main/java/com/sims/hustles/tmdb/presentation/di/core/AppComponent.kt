package com.sims.hustles.tmdb.presentation.di.core

import com.sims.hustles.tmdb.presentation.di.artist.ArtistSubComponent
import com.sims.hustles.tmdb.presentation.di.movie.MovieSubComponent
import com.sims.hustles.tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}