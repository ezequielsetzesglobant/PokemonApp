package com.example.pokemonapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.pokemonapp.R
import com.example.pokemonapp.adapter.ViewPagerAdapter
import com.example.pokemonapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewPagerMainFragment.adapter =
            ViewPagerAdapter(listOf(CardTypeFragment(), CardSubTypeFragment(), CardSuperTypeFragment()), parentFragmentManager, lifecycle)
        attachFragmnents(binding.tabLayoutMainFragment, binding.viewPagerMainFragment)
        return binding.root
    }

    private fun attachFragmnents(tabLayout: TabLayout, viewPager: ViewPager2) {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                TYPES_TAB -> {
                    tab.text = getString(R.string.tab_layout_main_fragment_tab_name_type)
                }
                SUB_TYPES_TAB -> {
                    tab.text = getString(R.string.tab_layout_main_fragment_tab_name_subtypes)
                }
                SUPER_TYPES_TAB -> {
                    tab.text = getString(R.string.tab_layout_main_fragment_tab_name_supertypes)
                }
            }
        }.attach()
    }

    companion object {
        private const val TYPES_TAB = 0
        private const val SUB_TYPES_TAB = 1
        private const val SUPER_TYPES_TAB = 2
    }
}
