package com.sims.hustles.tmdb.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.sims.hustles.tmdb.data.models.movies.Movie
import com.sims.hustles.tmdb.data.repository.movie.FakeMovieRepository
import com.sims.hustles.tmdb.domain.usecase.GetMoviesUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateMoviesUseCase
import com.sims.hustles.tmdb.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "path1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "path2", "date2", "title2"))

        val currentMovieList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentMovieList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "path3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "path4", "date4", "title4"))

        val updatedMovieList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedMovieList).isEqualTo(movies)
    }
}