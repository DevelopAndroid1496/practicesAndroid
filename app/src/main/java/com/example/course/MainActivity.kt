package com.example.course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(),MainFragment.CourseSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar.apply { this!!.hide() }
        initNavigation()
    }

    private fun initNavigation(){
        val mainFragment = MainFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .replace(R.id.root_layout,mainFragment,MainFragment.TAG)
            .commit()
    }

    override fun onCourseSelected(position: Int) {
        when(position){
            0->{

            }
            1->{

            }
        }
    }
}