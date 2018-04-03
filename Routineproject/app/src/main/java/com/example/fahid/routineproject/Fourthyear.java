package com.example.fahid.routineproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fourthyear extends AppCompatActivity {
    Button b4th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthyear);
        b4th=(Button)findViewById(R.id.button4th);
        setTitle("Fourth Year");
        b4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Showallrcd4th.class);
                startActivity(intent);
            }
        });
    }
}
