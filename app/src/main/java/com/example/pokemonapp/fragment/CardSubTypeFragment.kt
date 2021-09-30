package com.example.pokemonapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokemonapp.databinding.FragmentCardSubTypeBinding

class CardSubTypeFragment : Fragment() {

    private lateinit var binding: FragmentCardSubTypeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCardSubTypeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
