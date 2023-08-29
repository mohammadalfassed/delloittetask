package com.mohammad.delloittetask.features.news.data.remote

import com.mohammad.delloittetask.features.news.data.remote.response.RemoteNewsListWrapper
import retrofit2.http.*

interface RemoteNewsDataSource {

    @GET("mostpopular/v2/viewed/{period}.json")
    suspend fun getPopularNews(
        @Path("period") period: Int?,
        @Query("api-key") apiKey: String = "V8HwRZhydtv38GKq0WJm0Kjy01Rh1el6",
    ): RemoteNewsListWrapper

}
