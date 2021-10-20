package com.example.quizontheplanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizontheplanet.databinding.FragmentAnswerBinding
import com.example.quizontheplanet.databinding.FragmentQuestionBinding

class AnswerFragment : Fragment() {
    lateinit var binding: FragmentAnswerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnswerBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString("message")

        binding.tvAnswerUser.text = message

        binding.btnBackQuestion.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_answerFragment_to_questionFragment)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = AnswerFragment()
    }
}