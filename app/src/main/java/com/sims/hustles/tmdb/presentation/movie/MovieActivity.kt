package com.sims.hustles.tmdb.presentation.movie

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class MovieActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Enables Always-on
        setAmbientEnabled()
    }
}