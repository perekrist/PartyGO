package com.example.partygo.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.partygo.R
import com.example.partygo.events
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class SearchFragment : Fragment(), OnMapReadyCallback,  GoogleMap.OnMarkerClickListener {
    override fun onMarkerClick(p0: Marker?): Boolean {
        return false
    }

    private lateinit var mMap: GoogleMap

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val place = LatLng(40.73, -73.99)
        mMap.addMarker(MarkerOptions().position(place))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

        println("hello")
        for (i in events) {
            addMark(i.lat, i.lng)
            println(i.lat)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_search, container, false)

        return root
    }

    private fun addMark(lat: Double, lng: Double) {
        val place = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(place))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

    }
}