package com.example.androidtrivia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtrivia.R
import com.example.androidtrivia.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater,
            R.layout.fragment_quiz,
            container,
            false
        );
        binding.overBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizFragment_to_quizOverFragment);
        }

        binding.winBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizFragment_to_quizWinFragment);
        }
        return binding.root;
    }


}