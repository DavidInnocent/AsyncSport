package com.asynclabs.asyncsport.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.asynclabs.asyncsport.api.repository.MainRepository
import com.asynclabs.asyncsport.api.retrofit.RetrofitService
import com.asynclabs.asyncsport.databinding.FragmentHomeBinding
import com.asynclabs.asyncsport.ui.home.factory.HomeViewModelFactory

class HomeFragment : Fragment() {

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
            ViewModelProvider(this, HomeViewModelFactory(MainRepository(retrofitService))).get(
                HomeViewModel::class.java
            )

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.feedList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreateView: $it")
        })
        homeViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onViewCreated: $it")
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getAllFeeds(10,"football");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}