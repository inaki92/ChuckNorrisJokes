package com.example.chucknorrisjokes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView

import com.example.chucknorrisjokes.Model.Object
import com.example.chucknorrisjokes.ViewModel.JokesViewModel

class CharDialogFragment : DialogFragment() {

    private var idJoke: TextView? = null
    private var mJoke: TextView? = null

    internal var charList: Object? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.dialog_custom, container, false)
        val wmlp = dialog.window!!.attributes
        wmlp.width = WindowManager.LayoutParams.WRAP_CONTENT
        wmlp.height = WindowManager.LayoutParams.MATCH_PARENT
        wmlp.gravity = Gravity.CENTER
        dialog.window!!.attributes = wmlp

        val b = arguments!!
        val myName = b.getString("name")
        val lastName = b.getString("lastname")

        Log.d(TAG, "onNameITS: " + myName!!)

        idJoke = view.findViewById(R.id.id_joke)
        mJoke = view.findViewById(R.id.joke_rdm)
        val mDismiss = view.findViewById<TextView>(R.id.dis_btn)

        val model = ViewModelProviders.of(this).get(JokesViewModel::class.java)
        model.getChar(myName, lastName).observe(this, Observer { jokesObject ->
            charList = jokesObject
            assert(charList != null)
            mJoke!!.text = charList!!.value!!.joke
            idJoke!!.text = charList!!.value!!.id
        })

        mDismiss.setOnClickListener {
            Log.d(TAG, "onClick: closing dialog")
            dialog.dismiss()
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
