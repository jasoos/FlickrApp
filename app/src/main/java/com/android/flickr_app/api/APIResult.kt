package com.android.flickr_app.api

interface APIResult<T> {
    fun success(value: T)
    fun failure(value: T)
}