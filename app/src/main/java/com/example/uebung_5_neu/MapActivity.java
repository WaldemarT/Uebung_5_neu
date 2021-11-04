package com.example.uebung_5_neu;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    double lat = 49.014362;
    double lon = 8.404128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getDouble("LAT");
            lon = bundle.getDouble("LON");
        }

        Mapbox.getInstance(this, getString(R.string.access_token));

        setContentView(R.layout.activity_map);

        Permissions.check(this, Manifest.permission.ACCESS_FINE_LOCATION, null, new PermissionHandler() {
            @Override
            public void onGranted() {
                Toast.makeText(MapActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
        });

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {

                mapboxMap.getUiSettings().setCompassEnabled(true);
                mapboxMap.getUiSettings().setAllGesturesEnabled(true);

                mapboxMap.setCameraPosition(new CameraPosition.Builder()
                        .zoom(12)
                        .target(new LatLng(lat, lon))
                        .tilt(9)
                        .build());

                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title("Koordinaten: " + lat + " ; " + lon));

                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}