package com.example.partygo.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.partygo.R


class SampleAdapter(
    private val mContext: Context,
    private val names: ArrayList<String>,
    private  val images: ArrayList<Int>
) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_sample, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

//        holder.image = BitmapFactory.decodeResource(mContext.resources ,R.drawable.lhd) as ImageView
        holder.image.setImageDrawable(ContextCompat.getDrawable(mContext, images[position]))
        holder.name.text = names[position]

        holder.image.setOnClickListener {
            Log.d(TAG, "onClick: clicked on an image: " + names[position])
            Toast.makeText(mContext, names[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return names.size
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