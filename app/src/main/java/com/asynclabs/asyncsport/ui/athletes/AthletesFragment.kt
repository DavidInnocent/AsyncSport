package com.asynclabs.asyncsport.ui.athletes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.asynclabs.asyncsport.databinding.FragmentAthletesBinding
import com.asynclabs.asyncsport.ui.athletes.adapter.AthleteProfilePagerAdapter
import com.labo.kaji.fragmentanimations.MoveAnimation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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

        binding.athletesViewPager.adapter = athletesAdapter
        binding.athletesViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

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


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        return if (enter) {
            MoveAnimation.create(MoveAnimation.RIGHT, enter, 700)
        } else {
            //            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            MoveAnimation.create(MoveAnimation.DOWN, enter, 700)
        }
    }
}