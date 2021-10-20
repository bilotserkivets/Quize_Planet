package com.example.quizontheplanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizontheplanet.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questions = listOf<View>(
            binding.tvQuestion1,
            binding.tvQuestion2,
            binding.tvQuestion3
        )

        for (v in questions) {
            v.setOnClickListener{
                val bundle = Bundle()
                val questionId = v.id
                bundle.putInt("questionId", questionId )
                (activity as MainActivity).navController.navigate(R.id.action_startFragment_to_questionFragment, bundle)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = StartFragment()
    }
}