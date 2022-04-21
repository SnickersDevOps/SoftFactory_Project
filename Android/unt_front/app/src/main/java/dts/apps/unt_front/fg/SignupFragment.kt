package dts.apps.unt_front.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dts.apps.unt_front.databinding.FragmentCoursesBinding
import dts.apps.unt_front.databinding.FragmentSingupBinding


class SignupFragment : Fragment(){
    private var binding_1 : FragmentSingupBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding_1 = FragmentSingupBinding.inflate(inflater , container , false)


        return binding_2.root
    }
}