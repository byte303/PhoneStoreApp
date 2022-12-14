package frog.company.phonestoreapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import frog.company.phonestoreapp.databinding.DialogFilterBinding

class BottomDialogFilter : BottomSheetDialogFragment() {

    private var _binding : DialogFilterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DialogFilterBinding.inflate(inflater, container, false)

        return binding.root
    }
}