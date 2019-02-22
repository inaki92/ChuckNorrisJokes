package com.example.chucknorrisjokes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.chucknorrisjokes.Adapters.RandomJokeAdapter
import com.example.chucknorrisjokes.Model.Batches.JokesList

import com.example.chucknorrisjokes.ViewModel.JokesViewModel
import kotlinx.android.synthetic.main.fragment_all_jokes.view.*


class AllJokesFragment : Fragment() {

    private lateinit var mAdapter: RandomJokeAdapter
    private lateinit var myRecyclerView:RecyclerView
    private lateinit var allJokeList: JokesList

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val jokeView = inflater.inflate(R.layout.fragment_all_jokes, container, false)

        myRecyclerView = jokeView.jokes_recycler

        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayout.VERTICAL,false)

        load()

        return jokeView
    }


    private fun load() {

        val model = ViewModelProviders.of(this).get(JokesViewModel::class.java)

        model.allJokes.observe(this, Observer<JokesList> { allList ->
            allJokeList = allList!!
            mAdapter = RandomJokeAdapter(context,allJokeList)
            myRecyclerView.adapter = mAdapter
        })
        }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        private const val TAG = "AllJokesFragment"

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): AllJokesFragment {
            val fragment = AllJokesFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
