package com.example.googlemapsapi;

import android.Manifest.permission;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
// Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        LatLng nyc = new LatLng(40.7128, -74.0060);
        googleMap.addMarker(new MarkerOptions().position(nyc).title("Marker in NYC"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        UiSettings uiSettings = this.googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setAllGesturesEnabled(true);

        if (ActivityCompat.checkSelfPermission(
                this, permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(
                this, permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, new String[]{permission.ACCESS_FINE_LOCATION,
                            permission.ACCESS_COARSE_LOCATION}, 1020);
        } else {
            googleMap.setMyLocationEnabled(true);
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        private GoogleMap googleMap;

                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double lat = location.getLatitude();
                                double lng = location.getLongitude();
                                this.googleMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(lat, lng))
                                        .title("NYC Marker"));
                            }
                        }
                    });

        }

        Geocoder geocoder = new Geocoder(getApplicationContext());
        List<Address> address;
        LatLng latLng = null;
        try {
            address = geocoder.getFromLocationName("70-28 Austin Street Forest Hills, NY 11375", 5);
            if (address != null) {
                Address location = address.get(0);
                latLng = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Best Bakery in NYC").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_bestbakeryofalltime)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Address> address2;
        LatLng latlng2 = null;

        try {
            address2 = geocoder.getFromLocationName("472 Gramatan Road, Mount Vernon, NY 10552", 5);
            if (address2 != null) {
                Address location = address2.get(1);
                latlng2 = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(latlng2).title("Home").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_property)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        List<Address> address3;
        LatLng latLng3 = null;

        try {
            address3 = geocoder.getFromLocationName("98-11 44th Avenue, Queens, NY 11368", 5);
            if (address3 != null) {
                Address location = address3.get(2);
                latLng3 = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(latLng3).title("Work").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_work)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        List<Address> address4;
        LatLng latlng4 = null;

        try {
            address4 = geocoder.getFromLocationName("47-10 Austell Pl, Long Island City, NY 11101", 5);
            if (address4 != null) {
                Address location = address4.get(3);
                latlng4 = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(latlng4).title("School").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_school)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        List<Address> address5;
        LatLng latlng5 = null;

        try {
            address5 = geocoder.getFromLocationName("5-35 51st Ave\n" +
                    "Long Island City, NY 11101", 5);
            if (address5 != null) {
                Address location = address5.get(4);
                latlng5 = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(latlng5).title("Namaste and float").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_zen)));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
