package com.example.partygo

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://demo9113139.mockable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EventAPI::class.java)

        val request = service.getCatFacts()

        request.enqueue(object : Callback<EventResponse> {
            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                println(t)
                println("sfaile")
            }

            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                println(response.body())

                val body = response.body()
                if(body != null) {
                    println("sucs")
                    println(body)
                    println("suce")


                }
            }

        })

        for(e in events){
            println("$events qwerty")
        }

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_chat, R.id.navigation_ticket, R.id.navigation_profile
            )
        )
        navView.setupWithNavController(navController)
    }
}
