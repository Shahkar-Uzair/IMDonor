package com.example.imdonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class userProfileDetail extends AppCompatActivity {

    String nameData;
    String locationData;
    String bloodData;
    String statusData;
    String messageData;
    String numberData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_detail);

        nameData = getIntent().getStringExtra("name");
        locationData = getIntent().getStringExtra("location");
        bloodData = getIntent().getStringExtra("blood");
        statusData = getIntent().getStringExtra("status");
        messageData = getIntent().getStringExtra("message");
        numberData = getIntent().getStringExtra("number");

        TextView name = findViewById(R.id.nameId);
        TextView location = findViewById(R.id.locationId);
        TextView status = findViewById(R.id.statusId);
        TextView bloodType = findViewById(R.id.bloodId);
        TextView message = findViewById(R.id.messageId);
        TextView id = findViewById(R.id.numberId);

        name.setText(nameData);
        location.setText(locationData);
        status.setText(statusData);
        bloodType.setText(bloodData);
        message.setText(messageData);
        id.setText(numberData);
    }



    public void viewAllPost(View view) {
        Intent i = new Intent(this, AllMessage.class);
        startActivity(i);
    }
}