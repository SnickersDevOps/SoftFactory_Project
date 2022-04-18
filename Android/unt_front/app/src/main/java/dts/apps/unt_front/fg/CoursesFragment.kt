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
    lateinit var binding_internal : FragmentCoursesBinding
    val binding_external get() = binding_internal

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding_internal = FragmentCoursesBinding.inflate(inflater , container , false)

        binding_internal.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemProfile -> view?.findNavController()?.navigate(R.id.action_coursesFragment_to_profileFragment)
            }
            true
        }

        return binding_internal.root
    }
}