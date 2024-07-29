package com.prabhakar.jantagrocery.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prabhakar.jantagrocery.databinding.FragmentOTPBinding

class OTPFragment : Fragment() {
    private lateinit var binding: FragmentOTPBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOTPBinding.inflate(layoutInflater)


        return binding.root

    }

}
