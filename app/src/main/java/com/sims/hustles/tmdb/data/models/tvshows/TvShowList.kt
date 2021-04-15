package com.sims.hustles.tmdb.data.models.tvshows

import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)