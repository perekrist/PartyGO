package com.example.partygo.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.partygo.Event
import com.example.partygo.R
import com.example.partygo.events
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_search.*
import android.graphics.Bitmap
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import android.content.Context
import android.graphics.Canvas


class SearchFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    override fun onMarkerClick(p0: Marker?): Boolean {
        return true
    }

    private lateinit var mMap: GoogleMap

    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

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

        search_bar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                mMap.clear()
                val regex = Regex(query)
                val currentEvents = events.filter {
                    it.name.contains(regex)
                    it.type.contains(regex)
                }
                for (i in currentEvents) {
                    addMark(i)
                }
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                mMap.clear()
                val regex = Regex(query)
                val currentEvents = events.filter {
                    it.name.contains(regex)
                    it.type.contains(regex)
                }
                for (i in currentEvents) {
                    addMark(i)
                }
                return true
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isCompassEnabled = false
        for (i in events) {
            addMark(i)
        }
    }


    private fun addMark(i: Event) {
        val place = LatLng(i.lat, i.lng)
        when {
            i.type == "education" -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.map))
                        .title(i.name)
                )
            }
            i.type == "music" -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.music))
                        .title(i.name)
                )
            }
            i.type == "dance" -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.sport))
                        .title(i.name)
                )
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

    }
}