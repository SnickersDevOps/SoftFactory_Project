package dts.apps.unt_front.fg

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dts.apps.unt_front.R
import dts.apps.unt_front.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding_internal : FragmentLoginBinding
    val binding_external get() = binding_internal

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding_internal = FragmentLoginBinding.inflate(inflater , container , false)

        binding_internal.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (p0.isValidEmail()) {
                    binding_internal.editTextEmail.error = null
                    binding_internal.btnLogin.setOnClickListener {
                        view?.findNavController()?.navigate(R.id.action_loginFragment_to_coursesFragment)
                    }
                }
                else { binding_internal.editTextEmail.error = "Invalid Email" }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        return binding_internal.root
    }
    fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

}