package com.example.pokemonapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.ItemRecyclerViewCardTypeFragmentBinding
import com.example.pokemonapp.utils.getImageId

class TypeAdapter(private var types: List<String>) : RecyclerView.Adapter<TypeAdapter.TypeHolder>() {

    class TypeHolder(private val binding: ItemRecyclerViewCardTypeFragmentBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(type: String) {
            binding.textViewItemRecyclerViewCardTypeFragmentType.text =
                context.getString(R.string.text_view_one_parameter, type)
            binding.imageViewItemRecyclerViewCardTypeFragmentType.setImageResource(type.getImageId())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeHolder =
        TypeHolder(ItemRecyclerViewCardTypeFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)

    override fun onBindViewHolder(holder: TypeHolder, position: Int) {
        holder.bind(types[position])
    }

    override fun getItemCount(): Int = types.size
}
