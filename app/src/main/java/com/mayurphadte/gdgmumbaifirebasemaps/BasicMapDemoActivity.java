/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mayurphadte.gdgmumbaifirebasemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class BasicMapDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    DatabaseReference myRef;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mMap.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    //HashMap name = postSnapshot.getValue(HashMap.class);
                    //Log.d("Hi",name.values().toArray().toString());

                    Double latitude = (Double)postSnapshot.child("latitude").getValue();
                    Double longitude = (Double)postSnapshot.child("longitude").getValue();
                    String name = (String)postSnapshot.child("name").getValue();
                    //Log.d("Hi",Double.toString(latitude)+" "+Double.toString(longitude));
                    if(latitude!=null&&longitude!=null){
                    mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(name));
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {


            }
        });
    }



    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        map.addMarker(new MarkerOptions().position(new LatLng(21, 11)).title("Marker"));
    }
}
