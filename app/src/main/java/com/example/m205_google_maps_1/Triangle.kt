package com.example.m205_google_maps_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class Triangle : AppCompatActivity() {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triangle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map2) as SupportMapFragment

        // Initialiser la carte avec getMapAsync()
        mapFragment.getMapAsync { googleMap ->
            mMap = googleMap

            // Coordonnées des sommets du triangle autour de Béjaâd
            val point1 = LatLng(32.77073633851901, -6.395962506461388) // Centre de Béjaâd
            val point2 = LatLng(32.770688976847595, -6.39590014510136) // Nord-Est
            val point3 = LatLng(32.77059989173069, -6.396000057387857) // Sud-Est
            val point4 = LatLng(32.770645561959995, -6.3960604070911105)

            // Dessiner le triangle
            val triangle = PolygonOptions()
                .add(point1, point2, point3, point4) // Relier les points pour fermer le triangle
                .strokeColor(0xFFFF0000.toInt()) // Couleur de la bordure (rouge)
                .strokeWidth(8f) // Épaisseur de la bordure
                .fillColor(0x7FFF0000.toInt()) // Couleur de remplissage semi-transparente (rouge)

            mMap.addPolygon(triangle)

            // Centrer la caméra sur le triangle
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point1, 18f))
        }

    }
}