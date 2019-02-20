package com.example.chucknorrisjokes

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_character.view.*

class CharacterFragment : Fragment() {

    private val TAG = "JokesDialogFragment"

    private lateinit var name:String
    private lateinit var lastname:String
    private lateinit var fName:String

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

        val view = inflater.inflate(R.layout.fragment_character,container,false)

        var charDialog:CharDialogFragment

        val button = view.sub_btn
        button.setOnClickListener {

            name = view.character_name.text.toString()

            if(view.character_name.text.isNotEmpty()){
                val str = name
                val reg = Regex(" ")
                val list = str.split(reg)
                fName = list[0]

                if (list.size < 2 || list.size > 2){
                    Toast.makeText(context,"Enter a valid Name and LastName",Toast.LENGTH_LONG).show()
                }else {
                    lastname = list[1]
                    val args = Bundle()
                    args.putString("name", fName)
                    args.putString("lastname", lastname)
                    charDialog = CharDialogFragment()
                    charDialog.arguments = args
                    charDialog.show(fragmentManager, "CharDialogFragment")
                }

            }else{
                Toast.makeText(context,"Enter a valid Name and LastName",Toast.LENGTH_LONG).show()
            }

        }
        return view
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

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): CharacterFragment {
            val fragment = CharacterFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
