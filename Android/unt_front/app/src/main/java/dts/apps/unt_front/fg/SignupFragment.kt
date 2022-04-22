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
import dts.apps.unt_front.databinding.FragmentCoursesBinding
import dts.apps.unt_front.databinding.FragmentSingupBinding


class SignupFragment : Fragment(){
    private var binding_1 : FragmentSingupBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentSingupBinding.inflate(inflater , container , false)
        emailEditTxtChecker()
        return binding_2.root
    }

    private fun CharSequence?.isValidEmail():Boolean{
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun emailEditTxtChecker() {
        binding_2.editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (p0.isValidEmail()) {
                    binding_2.editTextEmail.error = null
                    binding_2.btnSignup.setOnClickListener {
                        view?.findNavController()?.navigate(R.id.action_signupFragment_to_loginFragment)
                    }
                }
                else { binding_2.editTextEmail.error = "Invalid Email" }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}