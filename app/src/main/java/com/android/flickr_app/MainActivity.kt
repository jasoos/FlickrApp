package com.android.flickr_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            Fresco.initialize(this)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_holder, PhotosFragment())
                .commit()
        }
    }
}