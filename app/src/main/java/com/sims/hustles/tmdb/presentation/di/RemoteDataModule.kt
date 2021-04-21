package com.sims.hustles.tmdb.presentation.di

import com.sims.hustles.tmdb.data.api.TMDBService
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sims.hustles.tmdb.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.sims.hustles.tmdb.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }
}