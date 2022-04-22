package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentCoursesBinding
import dts.apps.unt_front.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var binding_1 : FragmentProfileBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentProfileBinding.inflate(inflater , container , false)
        onButtonClicked()
        onItemClicked()
        return binding_2.root
    }

    private fun onButtonClicked() {
        binding_2.btnEditProfile.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
        binding_2.btnAboutDevelopers.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_profileFragment_to_aboutDevelopersFragment)
        }
    }

    private fun onItemClicked() {
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemCourses -> view?.findNavController()?.navigate(R.id.action_profileFragment_to_coursesFragment)
            }
            true
        }
    }
}