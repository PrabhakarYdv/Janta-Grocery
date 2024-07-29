package com.prabhakar.jantagrocery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.prabhakar.jantagrocery.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        setStatusBarColor()
        return binding.root

    }

    private fun setStatusBarColor() {
        activity?.window?.apply {
            val color = ContextCompat.getColor(requireContext(), R.color.yellow)
            statusBarColor = color
        }
    }

}


