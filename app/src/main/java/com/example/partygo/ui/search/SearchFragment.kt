package com.example.partygo.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.partygo.R
import com.example.partygo.events
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    override fun onMarkerClick(p0: Marker?): Boolean {
        return true
    }

    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapView = view.findViewById(R.id.map) as MapView
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)

        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                mMap.clear()
                val regex = Regex(query)
                val currentEvents = events.filter {
                    it.name.contains(regex)
                }
                for (i in currentEvents){
                    addMark(i.lat, i.lng, i.name)
                }
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                mMap.clear()
                val regex = Regex(query)
                val currentEvents = events.filter {
                    it.name.contains(regex)
                }
                for (i in currentEvents){
                    addMark(i.lat, i.lng, i.name)
                }
                return true
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        for (i in events) {
            addMark(i.lat, i.lng, i.name)
        }
    }



    private fun addMark(lat: Double, lng: Double, title: String) {
        val place = LatLng(lat, lng)
        mMap.addMarker(MarkerOptions().position(place).title(title))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

    }
}