package com.android.flickr_app


import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.flickr_app.api.API_KEY
import com.android.flickr_app.api.FlickrAPI
import com.android.flickr_app.api.RetrofitClient
import com.android.flickr_app.data.PhotosBase
import com.android.flickr_app.room.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class PhotosViewModel(application: Application) : AndroidViewModel(application) {
    var flickrAPI: FlickrAPI = RetrofitClient.getPhotoRepository()
    var photos = MutableLiveData<List<Photo>>()
    val photoCountText = ObservableField<String>()
    val isPhotoCountVisible = ObservableInt()
    val isLoading = ObservableBoolean()
    val detailItem = MutableLiveData<Photo>()
    private var photosCallback: PhotosCallback? = null

    fun getPhotos() {
        flickrAPI.getRecent().enqueue(object : Callback<PhotosBase> {
            override fun onResponse(call: Call<PhotosBase>, response: Response<PhotosBase>) {
                Log.d("TAG", "onResponse: ")
                if (!response.body()?.stat?.toLowerCase(Locale.ROOT).equals("fail")) {
                    photos.value = response.body()?.photos?.photo
                    photoCountText.set(response.body()?.photos?.photo?.size.toString())
                }
            }

            override fun onFailure(call: Call<PhotosBase>, t: Throwable) {
                Log.d("TAG", "onResponse: ")
            }
        })
    }

    fun search(query: String) {
        flickrAPI.search(query).enqueue(object : Callback<PhotosBase> {
            override fun onResponse(call: Call<PhotosBase>, response: Response<PhotosBase>) {
                Log.d("TAG", "onResponse: ")
                if (!response.body()?.stat?.toLowerCase(Locale.ROOT).equals("fail")) {
                    photos.value = response.body()?.photos?.photo
                    photoCountText.set(response.body()?.photos?.photo?.size.toString())
                }
            }

            override fun onFailure(call: Call<PhotosBase>, t: Throwable) {
                Log.d("TAG", "onResponse: ")
            }
        })
    }

    fun perform(item:Photo) {
        Toast.makeText(getApplication(),"das",Toast.LENGTH_SHORT).show()
//        photosCallback?.onClickImage()
    }
}