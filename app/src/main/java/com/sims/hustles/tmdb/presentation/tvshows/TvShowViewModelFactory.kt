package com.sims.hustles.tmdb.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sims.hustles.tmdb.domain.usecase.GetTvShowUseCase
import com.sims.hustles.tmdb.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(private val getTvShowUseCase: GetTvShowUseCase,
private val updateTvShowUseCase: UpdateTvShowUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}