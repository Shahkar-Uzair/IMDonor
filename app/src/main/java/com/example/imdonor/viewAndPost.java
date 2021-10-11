package com.example.imdonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class viewAndPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_post);
    }

    public void viewPost(View view) {
        Intent i = new Intent(this, AllMessage.class);
        startActivity(i);
    }

    public void postRequest(View view) {
        Intent i = new Intent(this, postData.class);
        startActivity(i);
    }
}