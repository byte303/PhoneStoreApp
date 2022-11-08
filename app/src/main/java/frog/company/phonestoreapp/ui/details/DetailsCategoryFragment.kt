package frog.company.phonestoreapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import frog.company.phonestoreapp.R
import frog.company.phonestoreapp.databinding.FragmentDetailsCategoryBinding

class DetailsCategoryFragment : Fragment() {

    private lateinit var binding : FragmentDetailsCategoryBinding
    private var selectIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectIndex = arguments?.getInt(ARG_SECTION_NUMBER)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsCategoryBinding.inflate(inflater, container, false)



        return binding.root
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): DetailsCategoryFragment {
            return DetailsCategoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}