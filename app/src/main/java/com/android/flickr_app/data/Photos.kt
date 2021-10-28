package com.android.flickr_app.data

import com.android.flickr_app.room.Photo

class Photos {
    var page = 0
    var pages = 0
    var perpage = 0
    var total: String? = null
    var photo: List<Photo>? = null
}
