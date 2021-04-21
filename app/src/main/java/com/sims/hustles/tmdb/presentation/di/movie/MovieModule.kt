package com.sims.hustles.tmdb.presentation.di.movie
import com.sims.hustles.tmdb.domain.usecase.GetMoviesUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateMoviesUseCase
import com.sims.hustles.tmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMoviesUseCase: GetMoviesUseCase,
                                     updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}