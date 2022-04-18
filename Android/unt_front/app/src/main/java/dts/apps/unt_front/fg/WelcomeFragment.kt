package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding_internal : FragmentWelcomeBinding
    val binding_external get() = binding_internal

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding_internal = FragmentWelcomeBinding.inflate(inflater , container , false)

        binding_internal.btnLogIn.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        binding_internal.btnSignUp.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_signupFragment)
        }

        return binding_internal.root

    }
}