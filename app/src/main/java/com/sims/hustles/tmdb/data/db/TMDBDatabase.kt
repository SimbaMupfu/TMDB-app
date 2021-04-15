package com.sims.hustles.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sims.hustles.tmdb.data.db.dao.ArtistDao
import com.sims.hustles.tmdb.data.db.dao.MovieDao
import com.sims.hustles.tmdb.data.db.dao.TvShowDao
import com.sims.hustles.tmdb.data.models.artists.Artist
import com.sims.hustles.tmdb.data.models.movies.Movie
import com.sims.hustles.tmdb.data.models.tvshows.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvShowDao(): TvShowDao

    abstract fun artistDao(): ArtistDao
}