package com.example.android.navigation

import android.app.ActionBar
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding



class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title
        ,container, false)
        //new way

        binding.playButton.setOnClickListener { view: View->
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        /*binding.playButton.setOnClickListener{view: View? ->
            if (view != null) {
                //kotlin specific version of navigation
                //Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
                //androidx
                view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            }
        }*/
        //setting title for fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Android Trivia"
        //options menu enable
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}