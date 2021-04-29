package com.sims.hustles.tmdb.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sims.hustles.tmdb.data.db.dao.ArtistDao
import com.sims.hustles.tmdb.data.models.artists.Artist
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtistDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: ArtistDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.artistDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveArtistsTest() = runBlocking {
        val artists = listOf(Artist(1, "Sims", 99.0, "profilePath1"),
            Artist(2, "Clever", 89.0, "profilePath2"),
            Artist(3, "Ruziwa", 69.0, "profilePath3"))
        dao.saveArtists(artists)

        val savedArtists = dao.getArtists()
        Truth.assertThat(savedArtists).isEqualTo(artists)
    }

    @Test
    fun deleteArtistsTest() = runBlocking {
        val artists = listOf(Artist(1, "Sims", 99.0, "profilePath1"),
            Artist(2, "Clever", 89.0, "profilePath2"),
            Artist(3, "Ruziwa", 69.0, "profilePath3"))

        dao.saveArtists(artists)
        dao.deleteAllArtists()

        val artistResult = dao.getArtists()
        Truth.assertThat(artistResult).isEmpty()
    }
}