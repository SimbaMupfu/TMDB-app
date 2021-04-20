package com.sims.hustles.tmdb.data.repository.tvshow

import android.util.Log
import com.sims.hustles.tmdb.domain.repository.TvShowRepository
import com.sims.hustles.tmdb.data.models.tvshows.TvShow
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sims.hustles.tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShow(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()

        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch(ex: Exception){
            Log.i("TMDB", ex.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (ex: Exception){
            Log.i("TMDB", ex.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch(ex: Exception){
            Log.i("TMDB", ex.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}