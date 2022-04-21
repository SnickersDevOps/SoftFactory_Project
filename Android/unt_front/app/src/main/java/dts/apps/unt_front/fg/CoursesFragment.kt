package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {
    private var binding_1 : FragmentCoursesBinding? = null
    private val binding_2 get() = binding_1!!
    private var mCourseName: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentCoursesBinding.inflate(inflater , container , false)
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemProfile -> view?.findNavController()?.navigate(R.id.action_coursesFragment_to_profileFragment)
            }
            true
        }
        clickableImage()
        return binding_2.root
    }

    private fun clickableImage() {

        binding_2.imgCourseReadingLiteracy.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseHistoryKazakhstan.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseBiology.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseMathematicalLiteracy.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseMath.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCoursePhysics.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseGeography.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
        binding_2.imgCourseChemistry.setOnClickListener{ view?.findNavController()?.navigate(R.id.action_coursesFragment_to_coursePressedFragment) }
    }


    }
