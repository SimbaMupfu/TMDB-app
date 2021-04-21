package com.sims.hustles.tmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.sims.hustles.tmdb.data.db.TMDBDatabase
import com.sims.hustles.tmdb.data.db.dao.ArtistDao
import com.sims.hustles.tmdb.data.db.dao.MovieDao
import com.sims.hustles.tmdb.data.db.dao.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return tmdbDatabase.tvShowDao()
    }
}