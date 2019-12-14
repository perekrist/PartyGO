package com.example.partygo

class Event(
    var name: String,
    var image: Int,
    var lat: Double,
    var lng: Double
)

var events = arrayListOf(
    Event("LHD", R.drawable.lhd, 56.46, 84.95),
    Event("X-mas party", R.drawable.xmas, 56.46, 84.94),
    Event("HNY", R.drawable.hny, 56.46, 84.95)
)