package com.example.chucknorrisjokes

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterFragment.OnFragmentInteractionListener, AllJokesFragment.OnFragmentInteractionListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction
        val characterFragment: CharacterFragment
        val allJokesFragment: AllJokesFragment

        when (item.itemId) {
            R.id.random_jokes ->

                return@OnNavigationItemSelectedListener true
            R.id.chage_character -> {
                transaction = fragmentManager.beginTransaction()
                characterFragment = CharacterFragment()
                transaction.replace(R.id.container, characterFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.all_jokes -> {
                transaction = fragmentManager.beginTransaction()
                allJokesFragment = AllJokesFragment()
                transaction.replace(R.id.container, allJokesFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
