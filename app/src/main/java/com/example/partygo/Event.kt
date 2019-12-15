package com.example.partygo

class Event(
    var id: Int,
    var name: String,
    var lat: Double,
    var lng: Double,
    var type: String,
    var date: String,
    var time: String,
    var cost: String,
    var image: String,
    var users: ArrayList<String>
)

var events: ArrayList<Event> = arrayListOf()
//Event("LHD", R.drawable.lhd, 56.463591, 84.957177, "education"),
//    Event("X-mas party", R.drawable.xmas, 56.4695, 84.94751300000007, "music"),
//    Event("HNY", R.drawable.hny, 56.461462, 84.948264, "dance")