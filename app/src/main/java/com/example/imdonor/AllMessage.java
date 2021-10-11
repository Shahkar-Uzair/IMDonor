package com.example.imdonor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AllMessage extends AppCompatActivity {

    ArrayList<String> users;
    ArrayList<String> nameList;
    ArrayList<String> locationList;
    ArrayList<String> bloodTypeList;
    ArrayList<String> statusList;
    ArrayList<String> numberList;
    ArrayList<String> messageList;


    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_message);

        ListView list = findViewById(R.id.listViewId);
        customAdapter customAdapterobj = new customAdapter();


        nameList = new ArrayList<>();
        locationList = new ArrayList<>();
        bloodTypeList = new ArrayList<>();
        statusList = new ArrayList<>();
        numberList = new ArrayList<>();
        messageList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("userData");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()){
                    String name = String.valueOf(ds.child("name").getValue());
                    String location = String.valueOf(ds.child("location").getValue());
                    String bloodGroup = String.valueOf(ds.child("bloodType").getValue());
                    String status = String.valueOf(ds.child("status").getValue());
                    String number = String.valueOf(ds.child("number").getValue());
                    String message = String.valueOf(ds.child("message").getValue());

                    nameList.add(name);
                    locationList.add(location);
                    bloodTypeList.add(bloodGroup);
                    statusList.add(status);
                    numberList.add(number);
                    messageList.add(message);

                }

                list.setAdapter(customAdapterobj);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String nameItem = String.valueOf(nameList.get(position));
                 String locationItem = String.valueOf(locationList.get(position));
                 String bloodItem = String.valueOf(bloodTypeList.get(position));
                 String statusItem = String.valueOf(statusList.get(position));
                 String numberItem = String.valueOf(numberList.get(position));
                 String messageItem = String.valueOf(messageList.get(position));

                Intent i = new Intent(getApplicationContext(), userProfileDetail.class);
                i.putExtra("name",nameItem);
                i.putExtra("location",locationItem);
                i.putExtra("blood",bloodItem);
                i.putExtra("status",statusItem);
                i.putExtra("number", numberItem);
                i.putExtra("message", messageItem);

                startActivity(i);
            }
        });


    }
    //End


    class customAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return nameList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom, null);

            TextView name = (TextView)convertView.findViewById(R.id.nameId);
            TextView location = (TextView)convertView.findViewById(R.id.locationId);
            TextView bloodGroup = (TextView)convertView.findViewById(R.id.bloodGroupId);
            TextView status = (TextView)convertView.findViewById(R.id.statusId);


            name.setText(nameList.get(position));
            location.setText(locationList.get(position));
            bloodGroup.setText(bloodTypeList.get(position));
            status.setText(statusList.get(position));

            return convertView;
        }

    }


}