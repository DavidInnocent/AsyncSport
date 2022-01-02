package com.asynclabs.asyncsport.ui.athletes

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
import com.asynclabs.asyncsport.databinding.FragmentAthletesBinding
import com.asynclabs.asyncsport.ui.athletes.factory.AthletesViewModelFactory
import com.asynclabs.asyncsport.ui.home.HomeViewModel
import com.asynclabs.asyncsport.ui.home.factory.HomeViewModelFactory


class AthletesFragment : Fragment() {

    private val TAG = "AthletesFragment"

    private lateinit var athletesViewModel: AthletesViewModel
    private var _binding: FragmentAthletesBinding? = null

    private val retrofitService = RetrofitService.getInstance()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        athletesViewModel =
            ViewModelProvider(this, AthletesViewModelFactory(MainRepository(retrofitService))).get(
                AthletesViewModel::class.java
            )
        _binding = FragmentAthletesBinding.inflate(inflater, container, false)

        athletesViewModel.athleteList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreateView: $it")
        })
        athletesViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onViewCreated: $it")
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        athletesViewModel.getAllAthletes()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}