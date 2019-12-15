package com.example.partygo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partygo.R
import com.example.partygo.events
import com.example.partygo.user1
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(com.example.partygo.R.layout.fragment_profile, container, false)
        val rv = root.findViewById(R.id.rv_profile) as RecyclerView
        rv.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        val name: TextView = root.findViewById(com.example.partygo.R.id.text_name)
        val city: TextView = root.findViewById(com.example.partygo.R.id.text_city)
        val chipGroup: ChipGroup = root.findViewById(com.example.partygo.R.id.chipGroup)
        var image: ImageView = root.findViewById(com.example.partygo.R.id.imageView2)
        for (i in user1.Interests) {
            val chip = Chip(context)
            chip.text = i
            chipGroup.addView(chip)
        }
        name.text = user1.Name
        city.text = user1.City
        image.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(context!!, user1.Image))
        rv.adapter = AdapterProfile(this.context!!, events)
        return root
    }
}