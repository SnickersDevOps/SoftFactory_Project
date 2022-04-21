package dts.apps.unt_front.fg

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
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemProfile -> view?.findNavController()?.navigate(R.id.action_coursePressedFragment_to_profileFragment)
                R.id.itemCourses -> view?.findNavController()?.navigate(R.id.action_coursePressedFragment_to_coursesFragment)
            }
            true
        }

        return binding_2.root
    }
}