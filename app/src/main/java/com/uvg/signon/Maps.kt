package com.uvg.signon


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Maps : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createFragment()
    }
    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap
        createMarker()
    }

    private fun createMarker(){

        val coordinates = LatLng(14.603855429717857, -90.48924800281428)
        val marker = MarkerOptions(). position(coordinates). title("mi U")
        map.addMarker(marker)
        map.animateCamera(
                CameraUpdateFactory.newLatLngZoom(coordinates,18f),
                4000,
                null
        )
    }

}