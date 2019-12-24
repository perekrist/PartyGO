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
import android.content.Intent
import android.graphics.Canvas
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.partygo.ui.event.EventActivity


class SearchFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    override fun onMarkerClick(marker: Marker?): Boolean {
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
                    it.name.contains(regex) || it.type.contains(regex)
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
                    it.name.contains(regex) || it.type.contains(regex)
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
        mMap.setOnMapLongClickListener {
            addEvent(it)
        }
        mMap.uiSettings.isCompassEnabled = false
        for (i in events) {
            addMark(i)
        }
        mMap.setOnInfoWindowClickListener {
            var tag = 0
            for (i in events) {
                if (it.title == i.name) {
                    tag = i.id
                }
            }
            val intent = Intent(this.activity, EventActivity::class.java)
            intent.putExtra("id", "$tag")
            ContextCompat.startActivity(this.requireContext(), intent, null)
        }

    }

    private fun addEvent(latlng: LatLng) {
        val builder = AlertDialog.Builder(this.context!!)
        builder.setTitle("Add new event?")
        val dialogLayout = layoutInflater.inflate(R.layout.add_event, null)
        val eventName = dialogLayout.findViewById<EditText>(R.id.event_name)
        val eventType = dialogLayout.findViewById<EditText>(R.id.event_type)
        val eventDate = dialogLayout.findViewById<EditText>(R.id.event_date)
        val eventTime = dialogLayout.findViewById<EditText>(R.id.event_time)
        val eventCost = dialogLayout.findViewById<EditText>(R.id.event_cost)
        builder.setView(dialogLayout)
        builder.setPositiveButton(android.R.string.yes) { _, _ ->

            events.add(
                Event(
                    events.size,
                    eventName.text.toString(),
                    latlng.latitude,
                    latlng.longitude,
                    eventType.text.toString(),
                    eventDate.text.toString(),
                    eventTime.text.toString(),
                    eventCost.text.toString(),
                    R.drawable.default_img
                )
            )
            addMark(events[events.size - 1])
        }
        builder.show()
    }

    private fun addMark(i: Event) {
        val place = LatLng(i.lat, i.lng)
        when {
            i.type == "music" -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.music))
                        .title(i.name)
                )
            }
            i.type == "sport" -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.sport))
                        .title(i.name)
                )
            }
            else -> {
                mMap.addMarker(
                    MarkerOptions()
                        .position(place)
                        .icon(bitmapDescriptorFromVector(requireContext(), R.drawable.map))
                        .title(i.name)
                )
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 12.0f))

    }
}