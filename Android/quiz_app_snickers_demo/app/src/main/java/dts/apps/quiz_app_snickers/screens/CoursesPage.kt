package dts.apps.quiz_app_snickers.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import dts.apps.quiz_app_snickers.R
import dts.apps.quiz_app_snickers.databinding.FragmentCoursesPageBinding

class CoursesPage : Fragment() {
    private var binding_1: FragmentCoursesPageBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding_1 = FragmentCoursesPageBinding.inflate(inflater, container, false)

        useAllFun()

        return binding_2.root
    }

    private fun useAllFun() {
        clickableImage()
    }


    private fun clickableImage() {
        binding_2.imgCourseChemistry.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Химия")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseGeography.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "География")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseMath.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Математика")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseMathLiteracy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Математическая Грамотность")

            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseBiology.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Биология")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseQazHistory.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "История Казахстана")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCourseReadingLiteracy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Грамотность Чтения")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
        binding_2.imgCoursePhysics.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Физика")
            view?.findNavController()
                ?.navigate(R.id.action_coursesPage_to_chosenCoursePage, bundle)
        }
    }

}