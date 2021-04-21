package com.sims.hustles.tmdb.presentation

import android.app.Application
import com.sims.hustles.tmdb.BuildConfig
import com.sims.hustles.tmdb.presentation.di.Injector
import com.sims.hustles.tmdb.presentation.di.artist.ArtistSubComponent
import com.sims.hustles.tmdb.presentation.di.core.*
import com.sims.hustles.tmdb.presentation.di.movie.MovieSubComponent
import com.sims.hustles.tmdb.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}