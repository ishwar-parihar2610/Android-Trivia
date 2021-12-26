package com.example.androidtrivia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtrivia.R
import com.example.androidtrivia.databinding.FragmentHomeBinding

class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        );
         binding.playBtn.setOnClickListener {
             it.findNavController().navigate(R.id.action_homeFragment2_to_quizFragment);

         }

        return binding.root;
    }


}
