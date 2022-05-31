package dts.apps.quiz_app_snickers.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import dts.apps.quiz_app_snickers.R
import dts.apps.quiz_app_snickers.databinding.FragmentResultPageBinding

class ResultPage : Fragment() {
    private var binding_1: FragmentResultPageBinding? = null
    private val binding_2 get() = binding_1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding_1 = FragmentResultPageBinding.inflate(inflater, container, false)

        useAllFun()

        return binding_2.root
    }

    fun useAllFun() {
        getData()
        binding_2.btnRestart.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_resultPage_to_coursesPage)
        }
    }

    fun getData() {
        val score = arguments?.get("score").toString()
        binding_2.tvResult.text = "Вы набрали " + score + " баллов"
    }

}