package com.example.androidui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Geocoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidui.common.Constants
import com.example.androidui.util.showToast
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.android.synthetic.main.activity_location.*
import java.util.*


class LocationActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var myAddress: String
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        sharedPreferences =
            this.getSharedPreferences(Constants.Location.location, Context.MODE_PRIVATE)

        val apiKey = getString(R.string.google_maps_key)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apiKey)
        }

        initAutoCompletePlaces()

        btnUseCurrentLocation.setOnClickListener {
            getCurrentLocation()

        }
    }

    fun nextActivity(){
        val intent = Intent(this, BottomNavigationActivity::class.java)
        startActivity(intent)
    }

    private fun initAutoCompletePlaces() {

        val autocompleteFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(
            listOf(
                Place.Field.ADDRESS,
                Place.Field.NAME
            )
        )
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {

                myAddress = place.address.toString()


                editor = sharedPreferences.edit()
                editor.apply{
                    putString("location", myAddress)
                }.apply()
                nextActivity()

            }

            override fun onError(p0: Status) {
                showToast("Error: ${p0.statusMessage}")
            }

        })

    }

    private fun getCurrentLocation() {
        if (checkPermission()) {

            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { location ->

                if (location != null) {
                    val addresses = Geocoder(this, Locale.getDefault()).getFromLocation(
                        location.latitude,
                        location.longitude, 10
                    )
                    if (addresses.size > 0) {
                        myAddress = addresses[0].getAddressLine(0)


                        editor = sharedPreferences.edit()
                        editor.apply{
                            putString("location", myAddress)
                        }.apply()
                        nextActivity()

                    } else {
                        showToast("Place Not found")
                    }

                } else{ //showToast("Could not get the Location")
                    val addresses = Geocoder(this, Locale.getDefault()).getFromLocation(
                        12.9456, 77.5219,
                        5
                    )
                    myAddress = addresses[0].getAddressLine(0)

                    editor = sharedPreferences.edit()
                    editor.apply{
                        putString("location", myAddress)
                    }.apply()
                    nextActivity()
                }
            }
        } else {
            requestLocationPermission()
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)
        ) {
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
        } else
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                getCurrentLocation()

            } else {

                val requestAgain =
                    shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
                if (requestAgain) {
                    showToast("Location Permission Denied")
                } else {
                   showToast("Location Permission Denied, Go to settings and enable Permission")

                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Permission Required")
                    builder.setMessage(
                        "Permission is required to get the Location Details. " +
                                "\nClick Permit to go to settings and enable Permission"
                    )
                    builder.setCancelable(false)
                    builder.setPositiveButton("Permit")
                    { _, _ ->
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri: Uri = Uri.fromParts("package", packageName, null)
                        intent.data = uri
                        startActivity(intent)
                    }
                    builder.setNegativeButton("Cancel")
                    { dialog, _ ->

                        dialog.dismiss()
                    }
                    val alert = builder.create()
                    alert.show()

                }
            }
        }
    }

}