package com.sims.hustles.tmdb.presentation.di.core

import com.sims.hustles.tmdb.data.repository.artist.ArtistRepositoryImpl
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.sims.hustles.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sims.hustles.tmdb.data.repository.movie.MovieRepositoryImpl
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.sims.hustles.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.TvShowRepositoryImpl
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.sims.hustles.tmdb.domain.repository.ArtistRepository
import com.sims.hustles.tmdb.domain.repository.MovieRepository
import com.sims.hustles.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }
}