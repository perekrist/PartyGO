package com.example.partygo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.partygo.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.events


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val rv = root.findViewById(R.id.horizontal_rv) as RecyclerView
        rv.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)

        val rv2 = root.findViewById(R.id.horizontal_rv_2) as RecyclerView
        rv2.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.HORIZONTAL, false)

        val rv3 = root.findViewById(R.id.rv_3) as RecyclerView
        rv3.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)

        rv.adapter = SampleAdapter(this.context!!, events)
        rv2.adapter = SampleAdapter(this.context!!, events)

        rv3.adapter = AdapterUpcoming(this.context!!, events)

        return root
    }
}