package dts.apps.quiz_app_snickers.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dts.apps.quiz_app_snickers.Adapter.ChosenCourseAdapter
import dts.apps.quiz_app_snickers.Adapter.QuizPlayAdapter
import dts.apps.quiz_app_snickers.REST.Data.questionBody.questionBodyItem
import dts.apps.quiz_app_snickers.ViewModel.QuizPlayViewModel
import dts.apps.quiz_app_snickers.databinding.FragmentQuizPlayPageBinding

class QuizPlayPage : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuizPlayAdapter
    private var binding_1: FragmentQuizPlayPageBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(QuizPlayViewModel::class.java)
        binding_1 = FragmentQuizPlayPageBinding.inflate(inflater, container, false)

        recyclerView = binding_2.rvQuestionBody
        adapter = QuizPlayAdapter()
        recyclerView.adapter = adapter

        val quiz_id = arguments?.get("quiz_id")
        Log.i("quiz_id" , quiz_id.toString())

        viewModel.questionByQuizId(quiz_id as Int)
        viewModel.mQuestionList.observe(viewLifecycleOwner , { list ->
            list?.body()?.let { adapter.setData(it) }
        })

        return binding_2.root
    }

}