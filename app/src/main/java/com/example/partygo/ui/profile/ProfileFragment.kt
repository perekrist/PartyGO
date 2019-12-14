package com.example.partygo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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
        val name: TextView = root.findViewById(com.example.partygo.R.id.text_name)
        val city: TextView = root.findViewById(com.example.partygo.R.id.text_city)
        val chipGroup: ChipGroup = root.findViewById(com.example.partygo.R.id.chipGroup)
        for (i in user1.Interests) {
            val chip = Chip(context)
            chip.text = i
            chipGroup.addView(chip)
        }
        name.text = user1.Name
        city.text = user1.City
        return root
    }
}