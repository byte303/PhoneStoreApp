package frog.company.phonestoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import frog.company.phonestoreapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.viewPager,
            HomeFragment()
        ).commit()
    }
}