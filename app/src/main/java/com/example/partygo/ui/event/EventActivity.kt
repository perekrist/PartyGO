package com.example.partygo.ui.event

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.partygo.Event
import com.example.partygo.R
import com.example.partygo.events
import com.example.partygo.tickets
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val id_string: String = intent.getStringExtra("id")!!
        var id = id_string.toInt()
        var event = events[id]

        name.text = event.name
        date.text = event.date
        cost.text = event.cost
        type.text = event.type
        imageView.setImageDrawable(ContextCompat.getDrawable(this, event.image))


        var bought = false
        buy_ticket.setOnClickListener {
            for (i in tickets) {
                if (i == id) {
                    bought = true
                }
            }
            if (!bought) {
                tickets.add(id)
                Toast.makeText(this, "Ticket purchased successfully", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "You have already bought a ticket", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
