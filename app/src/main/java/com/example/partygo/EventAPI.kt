package com.example.partygo

import retrofit2.Call
import retrofit2.http.GET

interface EventAPI {
    @GET("/events")
    fun getCatFacts(): Call<EventResponse>
}