package com.sims.hustles.tmdb.presentation.di.tvshow
import com.sims.hustles.tmdb.domain.usecase.GetTvShowUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateTvShowUseCase
import com.sims.hustles.tmdb.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUseCase: GetTvShowUseCase,
                                      updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }
}