package com.android.flickr_app.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun getPhotoRepository(): FlickrAPI {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.flickr.com/")
                .client(httpClient)
                .build()
                .create(FlickrAPI::class.java)
        }
    }
//    private fun createAppDatabase(context: Context): AppDatabase =
//        Room.databaseBuilder<AppDatabase>(
//            context,
//            AppDatabase::class.java,
//            "flickr.sqlite"
//        ).build()
}