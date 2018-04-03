package com.example.fahid.routineproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secndyear extends AppCompatActivity {
    Button scnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secndyear);
        scnd=(Button)findViewById(R.id.button2nd);
        setTitle("Second year");

        scnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), Showallrcd2nd.class);

                startActivity(intent);


            }
        });
    }
}
