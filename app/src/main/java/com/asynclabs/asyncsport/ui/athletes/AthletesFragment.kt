package com.asynclabs.asyncsport.ui.athletes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.asynclabs.asyncsport.databinding.FragmentAthletesBinding


class AthletesFragment : Fragment() {

    private lateinit var athletesViewModel: AthletesViewModel
    private var _binding: FragmentAthletesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        athletesViewModel =
            ViewModelProvider(this).get(AthletesViewModel::class.java)

        _binding = FragmentAthletesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}