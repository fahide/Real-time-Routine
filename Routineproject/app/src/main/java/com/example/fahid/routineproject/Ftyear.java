package com.example.fahid.routineproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Ftyear extends AppCompatActivity {
   Button ft1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftyear);
     ft1=(Button)findViewById(R.id.button);
        setTitle("First Year");

        ft1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), Showallrecord.class);

                startActivity(intent);


            }
    });




    }


}
