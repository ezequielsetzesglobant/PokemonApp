package com.example.pokemonapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pokemonapp.databinding.FragmentSplashScreenBinding
import com.example.pokemonapp.utils.Event
import com.example.pokemonapp.viewmodel.SplashScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private val viewModel by viewModel<SplashScreenViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDataState().observe(viewLifecycleOwner, updateUIObserver)
        viewModel.navigateToMainFragment()
    }

    private val updateUIObserver = Observer<Event<SplashScreenViewModel.SplashScreenStatus>> { event ->
        when (event.getContentIfNotHandled()) {
            SplashScreenViewModel.SplashScreenStatus.NAVIGATE -> {
                binding.progressBarSplashScreenFragmentLoadWait.visibility = View.GONE
                view?.findNavController()?.navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToMainFragment())
            }
            SplashScreenViewModel.SplashScreenStatus.LOADING -> {
                binding.progressBarSplashScreenFragmentLoadWait.visibility = View.VISIBLE
            }
        }
    }
}
