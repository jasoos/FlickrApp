package com.android.flickr_app;

import com.android.flickr_app.room.Photo;

public interface PhotosCallback {
    void onClickImage(Photo item);
}
