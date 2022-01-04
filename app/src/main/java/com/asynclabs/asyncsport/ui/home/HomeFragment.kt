package com.asynclabs.asyncsport.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.asynclabs.asyncsport.databinding.FragmentHomeBinding
import com.asynclabs.asyncsport.ui.home.adapter.FeedViewPagerAdapter

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {


    @Inject
    lateinit var feedAdapter: FeedViewPagerAdapter
    private val TAG = "HomeFragment"


    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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