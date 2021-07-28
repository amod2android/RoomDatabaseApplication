package com.amod2android.roomdatabaseapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.amod2android.roomdatabaseapplication.R
import com.amod2android.roomdatabaseapplication.database.DatabaseBuilder
import com.amod2android.roomdatabaseapplication.database.User
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.users.observe(viewLifecycleOwner, Observer {
            textView.text = it.toString()
            Log.d("4343",it.toString())
        })

        val btn: Button = root.findViewById(R.id.button)

        btn.setOnClickListener {
            val db= DatabaseBuilder.getInstance(requireContext())
            val userDao=db.getUserDao()

            val user =User("amod","k.amod@sparken.net","")
            lifecycleScope.launch {
                userDao.insert(user).also {homeViewModel.setValue()}
                Log.d("4343",userDao.getAll().toString())
            }
        }

        val btnDelete: Button = root.findViewById(R.id.buttonDelete)

        btnDelete.setOnClickListener {
            val db= DatabaseBuilder.getInstance(requireContext())
            val userDao=db.getUserDao()

            val user =User("amod","k.amod@sparken.net","")
            lifecycleScope.launch {
                userDao.insert(user).also {homeViewModel.setValue()}
                Log.d("4343",userDao.getAll().toString())
            }
        }
        return root
    }
}