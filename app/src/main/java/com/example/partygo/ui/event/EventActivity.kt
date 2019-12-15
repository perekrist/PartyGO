package com.example.partygo.ui.event

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.partygo.Event
import com.example.partygo.R
import com.example.partygo.events
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val id_string:String = intent.getStringExtra("id")!!
        Toast.makeText(this, id_string, Toast.LENGTH_SHORT).show()
        var id=id_string.toInt()
        var event = events[id]

        name.text=event.name
        imageView.setImageDrawable(ContextCompat.getDrawable(this, event.image))
    }
}
