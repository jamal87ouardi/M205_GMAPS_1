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

class MainActivity : AppCompatActivity() {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtenir le fragment de la carte
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // Initialiser la carte avec getMapAsync()
        mapFragment.getMapAsync { googleMap ->
            mMap = googleMap

            // Ajouter un marqueur directement
            val schoolLocation = LatLng(32.7689763280268, -6.391555637041718) // Exemple : Paris
            mMap.addMarker(
                MarkerOptions()
                    .position(schoolLocation)
                    .title("École")
            )
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(schoolLocation, 15f))
        }
    }


}