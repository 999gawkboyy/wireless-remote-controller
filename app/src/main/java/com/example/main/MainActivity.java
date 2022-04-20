package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bt = (Button)findViewById(R.id.send);
        Button btxy = (Button)findViewById(R.id.xysend);
        EditText et = (EditText) findViewById(R.id.console);
        EditText etx = (EditText)findViewById((R.id.getx));
        EditText ety = (EditText)findViewById((R.id.gety));
        EditText clnum = (EditText)findViewById((R.id.number));
        EditText keylog = (EditText)findViewById((R.id.keylog));
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String consolescript = et.getText().toString();
                databaseReference.child("script").setValue(consolescript);
            }
        });

        btxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getX = etx.getText().toString();
                String getY = ety.getText().toString();
                String clicknum = clnum.getText().toString();
                databaseReference.child("mouse").setValue(getX+ ","+getY+","+clicknum);
            }
        });
        keylog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyl = keylog.getText().toString();
                databaseReference.child("keyboard").setValue(keyl);
            }
        });
    }

}