package dts.apps.unt_front.fg

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentCoursePressedBinding

class CoursePressedFragment : Fragment() {
    private var binding_1 : FragmentCoursePressedBinding? = null
    private val binding_2 get() = binding_1!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentCoursePressedBinding.inflate(inflater , container , false)
        onItemClicked()
        getData()

        return binding_2.root
    }

    private fun getData() {
        val course_name = arguments?.get("course_name")
        binding_2.txtCourseName.text = course_name.toString()
        setImages()
    }

    private fun setImages() {
        if (binding_2.txtCourseName.text == "Химия") { binding_2.imgCourse.setImageResource(R.drawable.chemistry) }
        else if (binding_2.txtCourseName.text == "География") { binding_2.imgCourse.setImageResource(R.drawable.geography) }
        else if (binding_2.txtCourseName.text == "Математика") { binding_2.imgCourse.setImageResource(R.drawable.math) }
        else if (binding_2.txtCourseName.text == "Математическая Грамотность") { binding_2.imgCourse.setImageResource(R.drawable.math_literacy) }
        else if (binding_2.txtCourseName.text == "Биология") { binding_2.imgCourse.setImageResource(R.drawable.biology) }
        else if (binding_2.txtCourseName.text == "История Казахстана") { binding_2.imgCourse.setImageResource(R.drawable.qaz_history) }
        else if (binding_2.txtCourseName.text == "Грамотность Чтения") { binding_2.imgCourse.setImageResource(R.drawable.read_literacy) }
        else if (binding_2.txtCourseName.text == "Физика") { binding_2.imgCourse.setImageResource(R.drawable.physics) }

    }

    private fun onItemClicked() {
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemProfile -> view?.findNavController()?.navigate(R.id.action_coursePressedFragment_to_profileFragment)
                R.id.itemCourses -> view?.findNavController()?.navigate(R.id.action_coursePressedFragment_to_coursesFragment)
            }
            true
        }
    }
}