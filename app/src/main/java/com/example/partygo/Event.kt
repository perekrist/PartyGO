package com.example.partygo

class Event(
    var name: String,
    var image: Int,
    var lat: Double,
    var lng: Double
)

var events = arrayListOf(
    Event("LHD", R.drawable.lhd, 56.463591, 84.957177),
    Event("X-mas party", R.drawable.xmas, 56.4695, 84.94751300000007),
    Event("HNY", R.drawable.hny, 56.461462, 84.948264)
)