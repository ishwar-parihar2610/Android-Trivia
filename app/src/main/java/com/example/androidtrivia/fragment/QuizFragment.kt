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

    data class Questions(
        val text: String,
        val answer: List<String>


    )

    private val questions: MutableList<Questions> = mutableListOf(
        Questions(
            text = "What is Out Country Name",
            answer = listOf("India", "America", "China", "Japan")

        ),

        Questions(
            text = "What is Capital Of India",
            answer = listOf("Delhi", "Jaipur", "Jodhpur", "Mumbai")

        ),

        Questions(
            text = "How many state in India",
            answer = listOf("29", "40", "28", "44")

        ),

        Questions(
            text = "How many district in Rajasthan",
            answer = listOf("33", "40", "50", "50")

        ),

        Questions(
            text = "Who's the father Of nation",
            answer = listOf("Mahatma Gandhi", "Narendra Modi", "Apj Abdul kalam", "Rahul Gandhi")

        ),


        )

    lateinit var currentQuestions: Questions;
    lateinit var answers: MutableList<String>;
    private var questionsIndex = 0;
    private var totalQuestions = 5;


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
        binding.questions = this
        randomizeQuestions();
        randomizeQuestions()
        binding.submitBtn.setOnClickListener {
            val checkId=binding.radioGroup.checkedRadioButtonId;
            if (checkId!=-1){
                var answerIndex=0
                when(checkId){
                    R.id.answerSecond->answerIndex=1
                    R.id.answerThird->answerIndex=2
                    R.id.answerFourth->answerIndex=3
                }

                if (answers[answerIndex]==currentQuestions.answer[0]){
                    questionsIndex++;
                    if (questionsIndex<totalQuestions){
                        currentQuestions=questions[questionsIndex]
                        setQuestion()
                        binding.invalidateAll()
                    }else{
                        it.findNavController().navigate(R.id.action_quizFragment_to_quizWinFragment)
                    }
                }else {
                    it.findNavController().navigate(R.id.action_quizFragment_to_quizOverFragment)
                }
            }
        }
        return binding.root;
    }

    private fun randomizeQuestions() {
        questions.shuffle();
        questionsIndex = 0;
        setQuestion();
    }

    private fun setQuestion() {
        currentQuestions = questions[questionsIndex]
        answers = currentQuestions.answer.toMutableList()
        answers.shuffle();
    }


}