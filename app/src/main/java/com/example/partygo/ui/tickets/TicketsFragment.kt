package com.example.partygo.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.*
import com.example.partygo.ui.home.SampleAdapter
import com.example.partygo.ui.profile.AdapterProfile
import kotlinx.android.synthetic.main.fragment_tickets.*

class TicketsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        evenickets.clear()
        for (i in events) {
            for (j in tickets) {
                if (i.id == j){
                    evenickets.add(i)
                }
            }
        }

        val root = inflater.inflate(R.layout.fragment_tickets, container, false)
        val rv = root.findViewById(R.id.rv_tickets) as RecyclerView
        rv.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        rv.adapter = AdapterProfile(this.context!!, evenickets)
        return root
    }


}