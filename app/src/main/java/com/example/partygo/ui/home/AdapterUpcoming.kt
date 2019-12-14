package com.example.partygo.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.Event
import com.example.partygo.R

class AdapterUpcoming(
    private val mContext: Context,
    private val events: ArrayList<Event>
) : RecyclerView.Adapter<AdapterUpcoming.ViewHolderUpcoming>() {
    override fun onBindViewHolder(holder: ViewHolderUpcoming, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, events[position].image))
        holder.name.text = events[position].name

        holder.image.setOnClickListener {
            Log.d(TAG, "onClick: clicked on an image: " + events[position].name)
            Toast.makeText(mContext, events[position].name, Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUpcoming {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_sample, parent, false)
        return ViewHolderUpcoming(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    inner class ViewHolderUpcoming(itemView: View) : RecyclerView.ViewHolder(itemView) {
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