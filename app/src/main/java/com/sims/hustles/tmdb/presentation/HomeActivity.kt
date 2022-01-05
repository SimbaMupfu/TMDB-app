package com.sims.hustles.tmdb.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sims.hustles.tmdb.R
import com.sims.hustles.tmdb.databinding.ActivityHomeBinding
import com.sims.hustles.tmdb.presentation.artists.ArtistActivity
import com.sims.hustles.tmdb.presentation.movie.MovieActivity
import com.sims.hustles.tmdb.presentation.tvshows.TvShowActivity
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.AppCenter

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "f3a18b99-0fce-45b5-aa4a-2c3a7203731d",
            Analytics::class.java, Crashes::class.java
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.apply {
            movieButton.setOnClickListener {
                val intent = Intent(this@HomeActivity, MovieActivity::class.java)
                startActivity(intent)
            }

            tvShowsButton.setOnClickListener {
                val intent = Intent(this@HomeActivity, TvShowActivity::class.java)
                startActivity(intent)
            }

            artistsButton.setOnClickListener {
                val intent = Intent(this@HomeActivity, ArtistActivity::class.java)
                startActivity(intent)
            }
        }
    }
}