package com.example.chucknorrisjokes

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.Switch
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterFragment.OnFragmentInteractionListener,
        AllJokesFragment.OnFragmentInteractionListener,RandomJokeFragment.OnFragmentInteractionListener {

    private val TAG = "MainActivity"

    lateinit var chuck:TextView
    lateinit var joke:TextView
    private lateinit var app_chuck:TextView
    private var mSwitch: Switch? = null
    private var mStateSw:String? = null

    private var characterFragment: CharacterFragment? = null
    private var allJokesFragment: AllJokesFragment? = null
    private var rdmJokeFrag: RandomJokeFragment? = null

    private var dialogFrag: JokesDialogFragment? = null

    private val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction



        when (item.itemId) {
            R.id.random_jokes -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE

                transaction = fragmentManager.beginTransaction()
                rdmJokeFrag = RandomJokeFragment()
                transaction.replace(R.id.container, rdmJokeFrag!!)
                transaction.commit()

                return@OnNavigationItemSelectedListener true
            }
            R.id.chage_character -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE
                transaction = fragmentManager.beginTransaction()
                characterFragment = CharacterFragment()
                transaction.replace(R.id.container, characterFragment!!)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.all_jokes -> {
                chuck.visibility = GONE
                joke.visibility = GONE
                app_chuck.visibility = GONE
                transaction = fragmentManager.beginTransaction()
                allJokesFragment = AllJokesFragment()
                transaction.replace(R.id.container, allJokesFragment!!)
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
        mSwitch = no_explicit_sw

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        mSwitch!!.setOnClickListener(View.OnClickListener {

            val args = Bundle()
            if(mSwitch!!.isChecked){
                mStateSw = "true"
                args.putString("dato",mStateSw)
                dialogFrag = JokesDialogFragment()
                dialogFrag!!.arguments = args
                Log.d(TAG,"data sent: "+args)
            }else{
                mStateSw = "false"
            args.putString("dato",mStateSw)
            dialogFrag = JokesDialogFragment()
            dialogFrag!!.arguments = args
            Log.d(TAG,"data sent: "+args)
            }

        })
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

}
