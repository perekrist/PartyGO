package com.example.partygo.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        println(p0)
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
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val place = LatLng(40.73, -73.99)
        mMap.addMarker(MarkerOptions().position(place))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

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