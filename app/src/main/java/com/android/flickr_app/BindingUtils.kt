package com.android.flickr_app


import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.flickr_app.data.Photo
import com.facebook.drawee.view.SimpleDraweeView



@BindingAdapter("photoTitle")
fun TextView.setPhotoTitle(item: Photo) {
    text = item.title
}


@BindingAdapter("photoImageview")
fun SimpleDraweeView.setPhotoImageview(item: Photo) {
    setImageURI(item.url_m)
}