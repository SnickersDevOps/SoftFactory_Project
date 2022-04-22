package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentEditprofileBinding


class EditProfileFragment : Fragment() {
    private var binding_1 : FragmentEditprofileBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentEditprofileBinding.inflate(inflater , container , false)
        onItemClicked()
        return binding_2.root
    }

    private fun onItemClicked() {
        binding_2.bottomNavbar.setOnNavigationItemSelectedListener{
            when(it.itemId) {
                R.id.itemProfile -> view?.findNavController()?.navigate(R.id.action_editProfileFragment_to_profileFragment)
                R.id.itemCourses -> view?.findNavController()?.navigate(R.id.action_editProfileFragment_to_coursesFragment)
            }
            true
        }
    }
}