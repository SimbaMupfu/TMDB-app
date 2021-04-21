package com.sims.hustles.tmdb.presentation.di

import com.sims.hustles.tmdb.data.db.dao.ArtistDao
import com.sims.hustles.tmdb.data.db.dao.MovieDao
import com.sims.hustles.tmdb.data.db.dao.TvShowDao
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.sims.hustles.tmdb.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.sims.hustles.tmdb.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}