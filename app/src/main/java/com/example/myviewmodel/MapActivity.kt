package com.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MapActivity : AppCompatActivity() {
    lateinit var mapViewModel: MapViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        mapViewModel=ViewModelProvider(this).get(MapViewModel::class.java)
        
    }
}