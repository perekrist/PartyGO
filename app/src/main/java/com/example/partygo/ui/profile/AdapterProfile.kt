package com.example.partygo.ui.profile

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.Event
import com.example.partygo.R
import com.example.partygo.ui.event.EventActivity
import com.example.partygo.ui.home.SampleAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterProfile(
    private val mContext: Context,
    private val events: ArrayList<Event>
) : RecyclerView.Adapter<AdapterProfile.ViewHolderProfile>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProfile {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_profile_visited, parent, false)
        return ViewHolderProfile(view)
    }

    override fun onBindViewHolder(holder: ViewHolderProfile, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        holder.date.text = events[position].date
        holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, events[position].image))
        holder.name.text = events[position].name
        holder.type.text = events[position].type
        holder.card.setOnClickListener {
            Log.d(TAG, "onClick: clicked on an image: " + events[position].name)
            val intent = Intent(mContext, EventActivity::class.java)
            intent.putExtra("id", position.toString())
            ContextCompat.startActivity(mContext, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class ViewHolderProfile(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var date: TextView
        internal var image: ImageView
        internal var name: TextView
        internal var type: TextView
        internal var image_count: ImageView
        internal var card: CardView

        init {
            date = itemView.findViewById(R.id.date)
            image = itemView.findViewById(R.id.image_upcoming)
            name = itemView.findViewById(R.id.name)
            type = itemView.findViewById(R.id.type)
            image_count = itemView.findViewById(R.id.image_upcoming)
            card = itemView.findViewById(R.id.cardVisited)
        }
    }

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}