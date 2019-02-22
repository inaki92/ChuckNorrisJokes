package com.example.chucknorrisjokes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
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
    private var jokesList: Object? = null

    private var stateBTN:String? = null

    private var mCategory: TextView? = null

    fun newInstance(stateBTN: String): JokesDialogFragment {
        val f = JokesDialogFragment()

        // Supply num input as an argument.
        val args = Bundle()
        args.putString("estado", stateBTN)
        f.arguments = args

        return f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            stateBTN = it.getString("noexplicit")
        }
        Log.d(TAG,"dato en dialogo: "+stateBTN)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.dialog_custom, container, false)

        idJoke = view.findViewById(R.id.id_joke)
        mJoke = view.findViewById(R.id.joke_rdm)
        mCategory = view.findViewById(R.id.txt_cat)
        val mDismiss = view.findViewById<TextView>(R.id.dis_btn)

//        val b = arguments
//        stateBTN = b!!.getBoolean("explicit")

        //Log.d(TAG,"data received: "+stateBTN)

        if (stateBTN == "true"){

            val model = ViewModelProviders.of(this).get(JokesViewModel::class.java)
            model.excludeJoke.observe(this, Observer { jokesExclude ->
                jokesList = jokesExclude
                assert(jokesList != null)
                mJoke!!.text = jokesList!!.value!!.joke
                idJoke!!.text = jokesList!!.value!!.id.toString()
                mCategory!!.text = "no explicit"
            })

        }else {

        val model = ViewModelProviders.of(this).get(JokesViewModel::class.java)
        model.joke.observe(this, Observer { jokesObject ->
            jokesList = jokesObject
            assert(jokesList != null)
            mJoke!!.text = jokesList!!.value!!.joke
            idJoke!!.text = jokesList!!.value!!.id.toString()
            mCategory!!.text = jokesList!!.value!!.categories.toString()
        })

        }

        mDismiss.setOnClickListener {
            Log.d(TAG, "onClick: closing dialog")
            dialog.dismiss()

        }
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
        val params = dialog.window!!.attributes
        params.width = WindowManager.LayoutParams.WRAP_CONTENT
        params.height = WindowManager.LayoutParams.FIRST_SUB_WINDOW
        dialog.window!!.attributes = params as android.view.WindowManager.LayoutParams
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    companion object {
        private const val TAG = "JokesDialogFragment"
    }
}
