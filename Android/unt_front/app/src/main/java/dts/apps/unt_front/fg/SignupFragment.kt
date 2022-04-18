package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dts.apps.unt_front.databinding.FragmentSingupBinding


class SignupFragment : Fragment(){
    lateinit var binding_internal : FragmentSingupBinding
    val binding_external get() = binding_internal

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding_internal = FragmentSingupBinding.inflate(inflater , container , false)


        return binding_internal.root
    }
}