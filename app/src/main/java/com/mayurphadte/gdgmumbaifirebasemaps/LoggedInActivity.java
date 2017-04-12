package com.mayurphadte.gdgmumbaifirebasemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoggedInActivity extends AppCompatActivity {
    EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
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


