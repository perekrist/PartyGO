package com.example.partygo.ui.profile

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.Event
import com.example.partygo.R
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

        val day = SimpleDateFormat("dd")
        val month = SimpleDateFormat("M")
        var a: String
        a = if (month.format(Date()) == "12") {
            "Dec"
        } else month.format(Date())
        //TODO() all months display correctly
        val currentDate = "$a ${day.format(Date()).toInt()+1+position}"

        holder.date.text = currentDate
        //holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, events[position].image))
        holder.name.text = events[position].name
        holder.type.text = "Event"
        //holder.count.text = "${events.size} more events"

    }

    override fun getItemCount(): Int {
        //return minOf(events.size,2)
        return events.size
    }

    inner class ViewHolderProfile(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var date: TextView
        internal var image: ImageView
        internal var name: TextView
        internal var type: TextView
        internal var image_count: ImageView
        //internal var count: TextView

        init {
            date = itemView.findViewById(R.id.date)
            image = itemView.findViewById(R.id.image_upcoming)
            name = itemView.findViewById(R.id.name)
            type = itemView.findViewById(R.id.type)
            image_count = itemView.findViewById(R.id.image_upcoming)
            //count = itemView.findViewById(R.id.count_of_more_events)
        }
    }

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}