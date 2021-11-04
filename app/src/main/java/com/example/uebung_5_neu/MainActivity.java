package com.example.uebung_5_neu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputLat;
    EditText inputLon;
    Button open_MapLatLng;
    double lat;
    double lon;

    Button open_MapHKA;
    double latHKA = 49.015877;
    double lonHKA = 8.390748;

    Button open_MapHBF;
    double latHBF = 48.99370;
    double lonHBF = 8.40190;

    Button open_MapPub;
    double latPub = 48.99939;
    double lonPub = 8.47506;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open_MapLatLng = findViewById(R.id.openMapLatLng);
        open_MapLatLng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLat = findViewById(R.id.inputLAT);
                String latitude = inputLat.getText().toString();
                Log.d("entered LAT", latitude);
                if (latitude.matches("")) {
                    Toast.makeText(MainActivity.this, "Bitte Latitude eingeben", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    lat = Double.parseDouble(inputLat.getText().toString());
                }

                inputLon = findViewById(R.id.inputLON);
                String longitude = inputLon.getText().toString();
                Log.d("entered LON", longitude);
                if (longitude.matches("")) {
                    Toast.makeText(MainActivity.this, "Bitte Longitude eingeben", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    lon = Double.parseDouble(inputLon.getText().toString());
                }

                if (lat != 0 & lon != 0) {
                    Intent explicitIntent = new Intent(MainActivity.this, MapActivity.class);
                    explicitIntent.putExtra("LAT", lat);
                    explicitIntent.putExtra("LON", lon);
                    Log.d("LAT-LON Custom: " + String.valueOf(lat), String.valueOf(lon));
                    startActivity(explicitIntent);
                }
            }
        });

        open_MapHKA = findViewById(R.id.openMapHKA);
        open_MapHKA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(MainActivity.this, MapActivity.class);
                explicitIntent.putExtra("LAT", latHKA);
                explicitIntent.putExtra("LON", lonHKA);
                Log.d("LAT-LON HKA: " + String.valueOf(latHKA), String.valueOf(lonHKA));
                startActivity(explicitIntent);
            }
        });
        open_MapHBF = findViewById(R.id.openMapHBF);
        open_MapHBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(MainActivity.this, MapActivity.class);
                explicitIntent.putExtra("LAT", latHBF);
                explicitIntent.putExtra("LON", lonHBF);
                Log.d("LAT-LON HBF: " + String.valueOf(latHBF), String.valueOf(lonHBF));
                startActivity(explicitIntent);
            }
        });
        open_MapPub = findViewById(R.id.openMapPub);
        open_MapPub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(MainActivity.this, MapActivity.class);
                explicitIntent.putExtra("LAT", latPub);
                explicitIntent.putExtra("LON", lonPub);
                Log.d("LAT-LON Pub: " + String.valueOf(latPub), String.valueOf(lonPub));
                startActivity(explicitIntent);
            }
        });
    }
}