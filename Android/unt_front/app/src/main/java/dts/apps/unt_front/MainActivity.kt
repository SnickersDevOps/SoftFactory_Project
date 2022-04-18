package dts.apps.unt_front

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = NavHostFragment.findNavController(navHost.getFragment()).currentDestination?.id

        if (currentFragment == R.id.coursesFragment) {
            bottom_nav_bar.visibility = View.VISIBLE
        }
        else if (currentFragment == R.id.welcomeFragment) {
            bottom_nav_bar.visibility = View.GONE
        }
    }




}