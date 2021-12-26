package com.example.androidtrivia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.androidtrivia.R
import com.example.androidtrivia.databinding.FragmentQuizOverBinding
import com.example.androidtrivia.databinding.FragmentQuizWinBinding


class QuizWinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentQuizWinBinding>(inflater,R.layout.fragment_quiz_win,container,false);
        binding.retakeBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizWinFragment_to_quizFragment);
        }
        return binding.root;
    }


}