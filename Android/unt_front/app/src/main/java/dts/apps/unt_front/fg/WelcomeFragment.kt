package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentCoursesBinding
import dts.apps.unt_front.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var binding_1 : FragmentWelcomeBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentWelcomeBinding.inflate(inflater , container , false)
        onButtonClicked()
        return binding_2.root

    }

    private fun onButtonClicked() {
        binding_2.btnLogIn.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        binding_2.btnSignUp.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_signupFragment)
        }
    }
}