package frog.company.phonestoreapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import frog.company.phonestoreapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val tabNames = arrayListOf("Shop","Details","Features")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false).apply {
            vm = DetailsViewModel()
        }

        binding.viewPagerTabs.adapter = PagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabs, binding.viewPagerTabs) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
        return binding.root
    }

}