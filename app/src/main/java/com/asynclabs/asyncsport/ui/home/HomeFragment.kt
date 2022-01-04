package com.asynclabs.asyncsport.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.VideoViewBindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.asynclabs.asyncsport.api.repository.MainRepository
import com.asynclabs.asyncsport.api.retrofit.RetrofitService
import com.asynclabs.asyncsport.databinding.FragmentHomeBinding
import com.asynclabs.asyncsport.ui.athletes.adapter.AthleteProfilePagerAdapter
import com.asynclabs.asyncsport.ui.home.factory.HomeViewModelFactory
import com.asynclabs.asyncsport.ui.home.util.adapter.FeedViewPagerAdapter
import com.google.android.exoplayer2.SimpleExoPlayer

class HomeFragment : Fragment() {

    private lateinit var feedAdapter: FeedViewPagerAdapter
    private val TAG = "HomeFragment"


    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null




    private val retrofitService = RetrofitService.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(requireActivity(), HomeViewModelFactory(MainRepository(retrofitService))).get(
                HomeViewModel::class.java
            )

        feedAdapter= FeedViewPagerAdapter()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.feedList.observe(viewLifecycleOwner, {
            Log.d(TAG, "onCreateView: $it")
            feedAdapter.submitList(it)

        })
        homeViewModel.errorMessage.observe(viewLifecycleOwner, {
            Log.d(TAG, "onViewCreated: $it")
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllFeeds(1,"football")
        binding.feedsViewPager.adapter=feedAdapter
        binding.feedsViewPager.orientation=ViewPager2.ORIENTATION_VERTICAL



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}