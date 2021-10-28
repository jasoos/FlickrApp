package com.android.flickr_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.flickr_app.R
import com.android.flickr_app.databinding.PhotosFragmentBinding
import com.android.flickr_app.data.Photo
import com.ferfalk.simplesearchview.SimpleSearchView


class PhotosFragment : androidx.fragment.app.Fragment(), PhotosCallback {

    private lateinit var photosViewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Get a reference to the binding object and inflate the fragment views.
        val binding: PhotosFragmentBinding = inflate(
            inflater, R.layout.photos_fragment, container, false
        )
        photosViewModel = ViewModelProvider(requireActivity()).get(PhotosViewModel::class.java)

        binding.viewModel = photosViewModel
        binding.toolbar.inflateMenu(R.menu.photos_menu)
        binding.searchView.setMenuItem(binding.toolbar.menu.findItem(R.id.search))
        binding.searchView.setKeepQuery(true)
        binding.searchView.setOnQueryTextListener(object : SimpleSearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                photosViewModel.search(newText)
                return false
            }

            override fun onQueryTextCleared(): Boolean {
                photosViewModel.getPhotos()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })
        val adapter = PhotosAdapter(this)
        binding.photoList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.photoList.adapter = adapter

        photosViewModel.photos.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        photosViewModel.getPhotos()
    }

    override fun onClickImage(item: Photo?) {
        Toast.makeText(context, item?.title.toString(), Toast.LENGTH_SHORT).show()
        photosViewModel.detailItem.value = item
        fragmentManager?.beginTransaction()?.replace(R.id.fragment_holder, DetailFragment())
            ?.addToBackStack("detail")?.commit()
    }
}