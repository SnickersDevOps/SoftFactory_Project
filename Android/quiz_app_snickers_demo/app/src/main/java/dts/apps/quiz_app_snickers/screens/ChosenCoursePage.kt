package dts.apps.quiz_app_snickers.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dts.apps.quiz_app_snickers.Adapter.ChosenCourseAdapter
import dts.apps.quiz_app_snickers.R
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourse
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourseItem
import dts.apps.quiz_app_snickers.ViewModel.ChosenCourseViewModel
import dts.apps.quiz_app_snickers.databinding.FragmentChosenCoursePageBinding

class ChosenCoursePage : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ChosenCourseAdapter
    private var binding_1: FragmentChosenCoursePageBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(ChosenCourseViewModel::class.java)
        binding_1 = FragmentChosenCoursePageBinding.inflate(inflater, container, false)
        useAllFun()
        recyclerView = binding_2.rvChosenCourse
        adapter = ChosenCourseAdapter()
        recyclerView.adapter = adapter

        if (binding_2.txtCourseName.text == "Химия") {
            viewModel.quizListChemistry()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "География") {
            viewModel.quizListGeography()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
            view?.findNavController()?.navigate(R.id.action_chosenCoursePage_to_quizPlayPage)
        } else if (binding_2.txtCourseName.text == "Математика") {
            viewModel.quizListMath()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "Математическая Грамотность") {
            viewModel.quizListMathLiteracy()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "Биология") {
            viewModel.quizListBiology()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "История Казахстана") {
            viewModel.quizListHistKaz()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "Грамотность Чтения") {
            viewModel.quizListReadLiteracy()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        } else if (binding_2.txtCourseName.text == "Физика") {
            viewModel.quizListPhysics()
            viewModel.mQuizList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setData(it) }
            })
        }



        return binding_2.root
    }


    private fun useAllFun() {
        getData()
    }

    private fun getData() {
        val course_name = arguments?.get("course_name")
        binding_2.txtCourseName.text = course_name.toString()
        setImages()
    }

    private fun setImages() {
        if (binding_2.txtCourseName.text == "Химия") {
            binding_2.imgCourse.setImageResource(R.drawable.chemistry)
        } else if (binding_2.txtCourseName.text == "География") {
            binding_2.imgCourse.setImageResource(R.drawable.geography)
        } else if (binding_2.txtCourseName.text == "Математика") {
            binding_2.imgCourse.setImageResource(R.drawable.math)
        } else if (binding_2.txtCourseName.text == "Математическая Грамотность") {
            binding_2.imgCourse.setImageResource(R.drawable.math_literacy)
        } else if (binding_2.txtCourseName.text == "Биология") {
            binding_2.imgCourse.setImageResource(R.drawable.biology)
        } else if (binding_2.txtCourseName.text == "История Казахстана") {
            binding_2.imgCourse.setImageResource(R.drawable.qaz_history)
        } else if (binding_2.txtCourseName.text == "Грамотность Чтения") {
            binding_2.imgCourse.setImageResource(R.drawable.read_literacy)
        } else if (binding_2.txtCourseName.text == "Физика") {
            binding_2.imgCourse.setImageResource(R.drawable.physics)
        }

    }

}