package com.example.mapintegration;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapintegration.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;

        LatLng l = new LatLng(22.9747,88.4337);

        MarkerOptions marker = new MarkerOptions().position(l).title("Kalyani");
        mMap.addMarker(marker);
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(l));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(l, 18f));


        // Circle
        mMap.addCircle(new CircleOptions().center(l).radius(1000).fillColor(Color.GREEN));

        //overlay
        /*
        mMap.addGroundOverlay(new GroundOverlayOptions().position(l,1000f,1000f)
                //.image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher_foreground))
                .clickable(true));

         */


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions marker = new MarkerOptions().position(latLng).title("location set");
                mMap.addMarker(marker);
                Geocoder geo = new Geocoder(MapsActivity.this);
                try {
                    ArrayList<Address> array = (ArrayList<Address>)geo.getFromLocation(latLng.latitude,latLng.longitude,1);
                    Log.d("address=========================================",array.get(0).getAddressLine(0));
                } catch (IOException e) {
                    Toast.makeText(MapsActivity.this, "No location Here", Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);

                }
            }
        });


    }
}