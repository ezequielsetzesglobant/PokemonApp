package com.example.pokemonapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapp.adapter.TypeAdapter
import com.example.pokemonapp.databinding.FragmentCardTypeBinding
import com.example.pokemonapp.utils.Event
import com.example.pokemonapp.viewmodel.CardTypeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardTypeFragment : Fragment() {

    private lateinit var typeAdapter: TypeAdapter
    private lateinit var binding: FragmentCardTypeBinding
    private val viewModel by viewModel<CardTypeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveDataState().observe(viewLifecycleOwner, updateUIObserver)
        viewModel.getTypes()
    }

    private val updateUIObserver = Observer<Event<CardTypeViewModel.CardTypeData>> { event ->
        val eventContent = event.getContentIfNotHandled()
        when (eventContent?.responseType) {
            CardTypeViewModel.CardTypeStatus.SUCCESSFUL -> {
                binding.progressBarCardTypeFragmentLoad.visibility = View.GONE
                eventContent.data.data.let {
                    initializeRecyclerView(it)
                }
            }
            CardTypeViewModel.CardTypeStatus.ERROR -> {
                binding.progressBarCardTypeFragmentLoad.visibility = View.GONE
                binding.textViewCardTypeFragmentTypesError.text = eventContent.error
            }
            CardTypeViewModel.CardTypeStatus.LOADING -> {
                binding.progressBarCardTypeFragmentLoad.visibility = View.VISIBLE
            }
        }
    }

    private fun initializeRecyclerView(types: List<String>) {
        typeAdapter = TypeAdapter(types)
        binding.recyclerViewCardTypeFragmentTypesList.apply {
            layoutManager = GridLayoutManager(context, COLUMNS_AMOUNT)
            adapter = typeAdapter
        }
    }

    companion object {
        private const val COLUMNS_AMOUNT = 2
    }
}
