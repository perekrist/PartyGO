package com.example.partygo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.partygo.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private var names = arrayListOf("LHD", "X-mas party", "hny")
    private var images = arrayListOf(R.drawable.lhd, R.drawable.xmas, R.drawable.hny)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val rv = root.findViewById(R.id.horizontal_rv) as RecyclerView
        rv.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)

        val adapter = SampleAdapter(this.context!!, names, images)
        rv.adapter = adapter

        return root
    }
}