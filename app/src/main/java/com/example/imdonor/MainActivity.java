package com.example.imdonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void signUp(View view) {
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, logIn.class);
        startActivity(intent);
    }

    public void postData(View view) {
        Intent i = new Intent(this, postData.class);
        startActivity(i);
    }

    public void userProfile(View view) {
        Intent i = new Intent(this, userProfileDetail.class);
        startActivity(i);
    }

    public void allData(View view) {
        Intent i = new Intent(this, AllMessage.class);
        startActivity(i);
    }
}