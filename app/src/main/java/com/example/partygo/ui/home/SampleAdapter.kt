package com.example.partygo.ui.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.partygo.Event
import com.example.partygo.R
import com.example.partygo.ui.event.EventActivity


class SampleAdapter(
    private val mContext: Context,
    private val events: ArrayList<Event>
) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_sample2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, events[position].image))
        holder.name.text = events[position].name

        holder.image.setOnClickListener {
            val intent = Intent(mContext, EventActivity::class.java)
            intent.putExtra("id", position.toString())
            startActivity(mContext, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var image: ImageView
        internal var name: TextView

        init {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.text)
        }
    }

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}