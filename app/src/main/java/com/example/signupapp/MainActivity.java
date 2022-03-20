package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.signup);
        EditText Name = findViewById(R.id.Name);
        EditText phone = findViewById(R.id.mobileNumber);
        EditText bio = findViewById(R.id.bio);
        EditText location = findViewById(R.id.location);
        EditText Age = findViewById(R.id.Age);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int error = 0;
                //Input Validation for Name
                if(Name.getText().toString().equals("")){
                    Name.setError("Please enter a Name");
                    error = 1;
                }
                //Input Validation for Age
                if(Age.getText().toString().equals("")){
                    Age.setError("Age is a mandatory Field");
                    error = 1;
                }else if(Age.getText().toString().length() <= 0 || Age.getText().toString().length() > 2 ){
                    Age.setError("Invalid Age");
                    error = 1;
                }
                //Input Validation for Bio
                if(bio.getText().toString().equals("")){
                    bio.setError("Enter Bio");
                    error = 1;
                }
                //Input Validation for Mobile Number
                if(phone.getText().toString().equals("")){
                    phone.setError("Enter your Phone Number");
                    error = 1;
                }else if(phone.getText().toString().length() != 10){
                    phone.setError("Invalid Phone Number");
                    error = 1;
                }
                //Input Validation for Location
                if(location.getText().toString().equals("")){
                    location.setError("Enter Location");
                    error = 1;
                }
                //Executed when the inputs are correctly entered
                if(error != 1){
                    //Create an intent to jump to the next Activity
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    //Bundle the values to be passed onto the next Activity
                    Bundle extras = new Bundle();
                    //Add items to the bundle in key-value pair
                    extras.putString("name",Name.getText().toString());
                    extras.putString("age",Age.getText().toString());
                    extras.putString("location",location.getText().toString());
                    extras.putString("bio",bio.getText().toString());
                    extras.putString("phone",phone.getText().toString());
                    //Pass to another activity by passing extras
                    i.putExtras(extras);
                    //Start the activity
                    startActivity(i);
                }
            }
        });
    }
}