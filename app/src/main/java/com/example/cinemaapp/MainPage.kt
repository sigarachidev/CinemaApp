package com.example.cinemaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cinemaapp.fragments.HomeFragment
import com.example.cinemaapp.fragments.TicketFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        val bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val homeFragment = HomeFragment()
        val ticketFragment = TicketFragment()

        makeCurrentFragment(homeFragment)

        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_ticket -> makeCurrentFragment(ticketFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}

