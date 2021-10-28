package com.android.flickr_app

import android.net.Uri
import java.util.*

typealias PhotoId = String

data class PhotoViewModel(
    val id: PhotoId = UUID.randomUUID().toString(),
    val link: Uri,
    val title: String? = null
) {

}