package com.example.partygo

var interests =
    arrayListOf("Music", "Hip-Hop", "Football", "Dance", "Thriller", "Comedy", "Adventure")
var users = arrayListOf(User("Sveto4ka", "Tomsk", interests, R.drawable.profile_photo, 0, "123456"))
var currentUser: User? = null

var tickets: ArrayList<Int> = arrayListOf()
var evenickets: ArrayList<Event> = arrayListOf()
