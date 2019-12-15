package com.example.partygo.ui.tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.R
import com.example.partygo.events
import com.example.partygo.tickets
import com.example.partygo.ui.home.SampleAdapter
import kotlinx.android.synthetic.main.fragment_tickets.*

class TicketsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tickets, container, false)

        if (tickets.isEmpty()) {
            placeholder.setBackgroundResource(R.drawable.placeholder_tickets)
        } else {
            val rv = root.findViewById(R.id.rv_tickets) as RecyclerView
            rv.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
            rv.adapter = TicketsAdapter(this.context!!, tickets)
        }
        return root
    }

}