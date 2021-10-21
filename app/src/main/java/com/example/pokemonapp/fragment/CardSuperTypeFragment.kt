package com.example.pokemonapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokemonapp.databinding.FragmentCardSuperTypeBinding

class CardSuperTypeFragment : Fragment() {

    private lateinit var binding: FragmentCardSuperTypeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardSuperTypeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
