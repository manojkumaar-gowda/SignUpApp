package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Creating an object for UI components
        TextView Name = findViewById(R.id.userName);
        TextView phone = findViewById(R.id.userMobileNumber);
        TextView bio = findViewById(R.id.userBio);
        TextView location = findViewById(R.id.userLocation);
        TextView Age = findViewById(R.id.userAge);

        //Getting data from the previous Intent
        Intent i = getIntent();
        Bundle extras = i.getExtras();

        //Appending the data to respective TextViews
        Name.append(extras.getString("name"));
        phone.append(extras.getString("phone"));
        bio.append(extras.getString("bio"));
        location.append(extras.getString("location"));
        Age.append(extras.getString("age"));
    }
}