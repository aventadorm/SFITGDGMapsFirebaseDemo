package com.mayurphadte.sfitgdgmapsfirebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = (EditText)findViewById(R.id.nameField);

    }

    public void setLocation(View v){
        Intent i = new Intent(this,MyLocationDemoActivity.class);
        i.putExtra("name",nameField.getText().toString());
        startActivity(i);
    }
    public void showMap(View v){
        Intent i = new Intent(this,BasicMapDemoActivity.class);
        i.putExtra("name",nameField.getText().toString());
        startActivity(i);

    }
}
