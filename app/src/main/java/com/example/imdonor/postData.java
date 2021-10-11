package com.example.imdonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postData extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myreference;
    private Spinner BloodGrouptype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);

        database = FirebaseDatabase.getInstance();

    }

    public void submitData(View view) {


        Spinner spinnerRoles = findViewById(R.id.BloodGrouptype);
        Spinner spinnerStatus = findViewById(R.id.status);
//        EditText status = findViewById(R.id.statusId);
        EditText location = findViewById(R.id.locationId);
        EditText name = findViewById(R.id.nameId);
        EditText number = findViewById(R.id.numberId);
        EditText message = findViewById(R.id.messageId);

        String bloodType = spinnerRoles.getSelectedItem().toString();
        String statusText = spinnerStatus.getSelectedItem().toString();
        String locationText = location.getText().toString();
        String nameText = name.getText().toString();
        String numberText = number.getText().toString();
        String messageText = message.getText().toString();

        myreference = database.getReference("userData");

        userDataHelperClass helperClass = new userDataHelperClass(bloodType, statusText, locationText, nameText, numberText, messageText);
        myreference.child(numberText).setValue(helperClass);

        Intent i  = new Intent(getApplicationContext(), AllMessage.class);
        startActivity(i);

        Toast.makeText(getApplicationContext(), "Post Added Successfuly", Toast.LENGTH_SHORT).show();

    }
}