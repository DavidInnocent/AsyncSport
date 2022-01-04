package com.asynclabs.asyncsport.ui.athletes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.asynclabs.asyncsport.databinding.FragmentAthletesBinding
import com.asynclabs.asyncsport.ui.athletes.adapter.AthleteProfilePagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class AthletesFragment : Fragment() {

    @Inject
    lateinit var athletesAdapter: AthleteProfilePagerAdapter
    private val TAG = "AthletesFragment"

    val athletesViewModel: AthletesViewModel by viewModels()
    private var _binding: FragmentAthletesBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAthletesBinding.inflate(inflater, container, false)

        athletesViewModel.athleteList.observe(viewLifecycleOwner, {
            Log.d(TAG, "onCreateView: $it")
            athletesAdapter.submitList(it)
        })
        athletesViewModel.errorMessage.observe(viewLifecycleOwner, {
            Log.d(TAG, "onViewCreated: $it")
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        athletesViewModel.getAllAthletes()
        binding.athletesViewPager.adapter=athletesAdapter
        binding.athletesViewPager.orientation= ViewPager2.ORIENTATION_VERTICAL
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}