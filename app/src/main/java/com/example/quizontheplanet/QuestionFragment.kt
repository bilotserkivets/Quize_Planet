package com.example.quizontheplanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizontheplanet.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionId = arguments?.getInt("questionId")
        when (questionId) {
            R.id.tvQuestion1 -> {
                binding.headerQuestion.text = getString(R.string.question_one)
            }
            R.id.tvQuestion2 -> {
                binding.headerQuestion.text = getString(R.string.question_two)
            }
            R.id.tvQuestion3 -> {
                binding.headerQuestion.text = getString(R.string.question_three)
            }
        }

        val planets = listOf<View>(
            binding.tvMercury,
            binding.tvVenus,
            binding.tvEarth,
            binding.tvMars,
            binding.tvJupiter,
            binding.tvSaturn,
            binding.tvUranus,
            binding.tvNeptune
        )
        for (v in planets) {
            v.setOnClickListener {
                var message = ""
                when (questionId) {
                    R.id.tvQuestion1 -> {
                        if (v.id == R.id.tvJupiter) {
                            message = getString(R.string.jupiter_answer, getString(R.string.correct))
                        } else {
                            message = getString(R.string.jupiter_answer, getString(R.string.wrong))
                        }
                    }
                    R.id.tvQuestion2 -> {
                        if (v.id == R.id.tvSaturn) {
                            message = getString(R.string.saturn_answer, getString(R.string.correct))
                        } else {
                            message = getString(R.string.saturn_answer, getString(R.string.wrong))
                        }
                    }
                    R.id.tvQuestion1 -> {
                        if (v.id == R.id.tvUranus) {
                            message = getString(R.string.uranus_answer, getString(R.string.correct))
                        } else {
                            message = getString(R.string.uranus_answer, getString(R.string.wrong))
                        }
                    }
                }
                val bundle = Bundle()

                bundle.putString("message", message)
                (activity as MainActivity).navController.navigate(R.id.action_questionFragment_to_answerFragment, bundle)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = QuestionFragment()
    }
}