package com.example.chucknorrisjokes

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterFragment.OnFragmentInteractionListener,
        AllJokesFragment.OnFragmentInteractionListener,RandomJokeFragment.OnFragmentInteractionListener {

    lateinit var chuck:TextView
    lateinit var joke:TextView
    private lateinit var app_chuck:TextView

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction
        val characterFragment: CharacterFragment
        val allJokesFragment: AllJokesFragment
        val jokesDialog:JokesDialogFragment

        when (item.itemId) {
            R.id.random_jokes -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE
                jokesDialog = JokesDialogFragment()
                jokesDialog.show(fragmentManager,"JokesDialogFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.chage_character -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE

                transaction = fragmentManager.beginTransaction()
                characterFragment = CharacterFragment()
                transaction.replace(R.id.container, characterFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.all_jokes -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE
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

        chuck = chuckNorris
        app_chuck = app_norris
        joke = chuck_norris

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
