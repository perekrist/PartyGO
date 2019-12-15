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
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_profile.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
        val name: TextView = view.findViewById(R.id.text_name)
        val city: TextView = view.findViewById(R.id.text_city)
        val chipGroup: ChipGroup = view.findViewById(R.id.chipGroup)
        val image: ImageView = view.findViewById(R.id.imageView2)
        for (i in user1.Interests) {
            val chip = Chip(context)
            chip.text = i
            chipGroup.addView(chip)
        }
        name.text = user1.Name
        city.text = user1.City
        image.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(context!!, user1.Image))
        rv_profile.adapter = AdapterProfile(this.context!!, events)
    }
}