package com.sims.hustles.tmdb.data.models.movies

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)