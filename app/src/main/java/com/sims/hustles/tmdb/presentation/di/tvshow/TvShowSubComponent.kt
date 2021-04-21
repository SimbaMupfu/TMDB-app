package com.sims.hustles.tmdb.presentation.di.tvshow

import com.sims.hustles.tmdb.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}