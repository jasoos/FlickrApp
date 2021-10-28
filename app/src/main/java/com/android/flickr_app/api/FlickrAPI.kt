package com.android.flickr_app.api

import com.android.flickr_app.data.PhotosBase
import com.android.flickr_app.room.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal const val URLS = "url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o"

interface FlickrAPI {

    @GET("services/rest/?method=flickr.photos.getRecent&nojsoncallback=1&format=json")
    fun getRecent(
        @Query("api_key") apiKey: String= API_KEY,
        @Query("extras") extras: String = URLS
    ): Call<PhotosBase>

    @GET("services/rest/?method=flickr.photos.search&nojsoncallback=1&format=json")
    fun search(
        @Query("text") text: String? = null,
        @Query("per_page") perPage: Int= PER_PAGE,
        @Query("api_key") apiKey: String= API_KEY,
        @Query("extras") extras: String = URLS
    ): Call<PhotosBase>
}