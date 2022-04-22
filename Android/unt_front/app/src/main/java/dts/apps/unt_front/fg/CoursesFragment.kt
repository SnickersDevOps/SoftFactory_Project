package dts.apps.unt_front.fg

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {
    private var binding_1: FragmentCoursesBinding? = null
    private val binding_2 get() = binding_1!!
    private var mCourseName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding_1 = FragmentCoursesBinding.inflate(inflater, container, false)
        onItemClicked()
        clickableImage()
        return binding_2.root
    }

    private fun clickableImage() {
        binding_2.imgCourseChemistry.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Химия")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseGeography.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "География")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseMath.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Математика")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseMathLiteracy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Математическая Грамотность")

            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseBiology.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Биология")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseQazHistory.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "История Казахстана")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCourseReadingLiteracy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Грамотность Чтения")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }
        binding_2.imgCoursePhysics.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("course_name", "Физика")
            view?.findNavController()
                ?.navigate(R.id.action_coursesFragment_to_coursePressedFragment, bundle)
        }


    }

    private fun onItemClicked() {
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itemProfile -> view?.findNavController()
                    ?.navigate(R.id.action_coursesFragment_to_profileFragment)
            }
            true
        }
    }

}
