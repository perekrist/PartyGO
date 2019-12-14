package com.example.partygo.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.partygo.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private var names = arrayListOf("LHD", "X-mas party", "HNY")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val rv = root.findViewById(R.id.horizontal_rv) as RecyclerView
        rv.layoutManager = LinearLayoutManager(this.activity)

        val adapter = SampleAdapter(this.context!!, names)
        rv.adapter = adapter

        return root
    }
}