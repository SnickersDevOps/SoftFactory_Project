package dts.apps.quiz_app_snickers.screens

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import dts.apps.quiz_app_snickers.R
import java.util.concurrent.TimeUnit


class StartLoadingPage : Fragment() {
    private var timer: CountDownTimer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        nextFragment(2000)

        return inflater.inflate(R.layout.fragment_start_loading, container, false)
    }

    private fun nextFragment(time: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                view?.findNavController()?.navigate(R.id.action_startLoadingPage_to_coursesPage)
            }
        }.start()
    }

}