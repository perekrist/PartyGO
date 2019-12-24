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
    var image: Int
)

var events = arrayListOf(
    Event(0,"Local Hack Day", 56.463591, 84.957177, "education", "14.12.2019", "10:00", "0$", R.drawable.lhd),
    Event(1,"Happy New Year Party",56.4695, 84.94751300000007, "music", "15.12.2019","23:00", "10$", R.drawable.xmas),
    Event(2,"X-mas Party", 56.461462, 84.948264, "music", "14.12.2019","00:00","100$", R.drawable.hny),
    Event(3,"Football Match", 56.473056, 84.95738099999994, "sport", "16.12.2019","12:00","52$", R.drawable.football),
    Event(4,"Contest of Pugacheva", 56.4869102, 84.94991049999999, "music", "19.12.2019","19:00","119$", R.drawable.pugach)
)