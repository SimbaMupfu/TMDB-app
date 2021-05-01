package com.sims.hustles.tmdb.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.sims.hustles.tmdb.data.db.dao.TvShowDao
import com.sims.hustles.tmdb.data.models.tvshows.TvShow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TvShowDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var tvShowDao: TvShowDao
    lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()

        tvShowDao = database.tvShowDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveTvShowsTest() = runBlocking {
        val tvShows = listOf(TvShow(1, "Tv Show 1", "Overview 1", "posterPath 1"),
            TvShow(2, "Tv Show 2", "Overview 2", "posterPath 2"),
            TvShow(3, "Tv Show 3", "Overview 3", "posterPath 3"))

        tvShowDao.saveTvShows(tvShows)

        val savedTvShows = tvShowDao.getTvShows()

        Truth.assertThat(savedTvShows).isEqualTo(tvShows)
    }

    @Test
    fun deleteTvShows() = runBlocking {
        val tvShows = listOf(TvShow(1, "Tv Show 1", "Overview 1", "posterPath 1"),
            TvShow(2, "Tv Show 2", "Overview 2", "posterPath 2"),
            TvShow(3, "Tv Show 3", "Overview 3", "posterPath 3"))

        tvShowDao.saveTvShows(tvShows)

        tvShowDao.deleteAllTvShows()

        Truth.assertThat(tvShowDao.getTvShows()).isEmpty()
    }
}