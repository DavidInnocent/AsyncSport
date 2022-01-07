package com.asynclabs.asyncsport.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.asynclabs.asyncsport.databinding.FragmentHomeBinding
import com.asynclabs.asyncsport.ui.home.adapter.FeedViewPagerAdapter

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.labo.kaji.fragmentanimations.MoveAnimation

import android.view.animation.Animation
import com.google.android.material.snackbar.Snackbar


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

        binding.feedsViewPager.adapter = feedAdapter
        binding.feedsViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        homeViewModel.feedList.observe(viewLifecycleOwner, {
            Log.d(TAG, "onCreateView: $it")
            feedAdapter.submitList(it)

        })
        homeViewModel.errorMessage.observe(viewLifecycleOwner, {
            Snackbar.make(requireView(),it, Snackbar.LENGTH_LONG).show()
            Log.d(TAG, "onViewCreated: $it")
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllFeeds(1, "football")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            MoveAnimation.create(MoveAnimation.LEFT, enter, 700)
        } else {
            //            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            MoveAnimation.create(MoveAnimation.DOWN, enter, 700)
        }
    }

}