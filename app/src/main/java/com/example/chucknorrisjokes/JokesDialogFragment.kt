package com.example.chucknorrisjokes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.renderscript.Sampler
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView

import com.example.chucknorrisjokes.Model.Jokes
import com.example.chucknorrisjokes.Model.Object
import com.example.chucknorrisjokes.ViewModel.JokesViewModel

class JokesDialogFragment : DialogFragment() {

    private var idJoke: TextView? = null
    private var mJoke: TextView? = null
    internal var jokesList: Object? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.dialog_custom, container, false)



        idJoke = view.findViewById(R.id.id_joke)
        mJoke = view.findViewById(R.id.joke_rdm)
        val mDismiss = view.findViewById<TextView>(R.id.dis_btn)

        val model = ViewModelProviders.of(this).get(JokesViewModel::class.java)
        model.joke.observe(this, Observer { jokesObject ->
            jokesList = jokesObject
            assert(jokesList != null)
            mJoke!!.text = jokesList!!.value!!.joke
            idJoke!!.text = jokesList!!.value!!.id
        })



        mDismiss.setOnClickListener {
            Log.d(TAG, "onClick: closing dialog")
            dialog.dismiss()

            val randomJokeFragment = RandomJokeFragment()
            val fragmentManager = fragmentManager
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.container, randomJokeFragment)
            transaction.commit()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        val params = dialog.window!!.attributes
        params.width = WindowManager.LayoutParams.WRAP_CONTENT
        params.height = WindowManager.LayoutParams.FIRST_SUB_WINDOW
        dialog.window!!.attributes = params as android.view.WindowManager.LayoutParams
    }

    companion object {
        private const val TAG = "JokesDialogFragment"
    }
}
