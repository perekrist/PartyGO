package com.example.partygo

import org.json.JSONStringer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EventAPI {
    @GET("/events")
    fun getEvent(): Call<EventResponse>

    @GET("/events")
    fun getSting(
        @Query("name") query: String
        //,
//        @Query("page") page: Int,
//        @Query("per_page") perPage: Int
    ): Call<String>
}