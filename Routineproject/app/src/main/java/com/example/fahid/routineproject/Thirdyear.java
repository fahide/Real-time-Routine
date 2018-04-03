package com.example.fahid.routineproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Thirdyear extends AppCompatActivity {
    Button b3rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdyear);
    b3rd=(Button)findViewById(R.id.button3rd);
        setTitle("Third Year");

        b3rd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Showallrcd3rd.class);
                startActivity(intent);

            }
        });
        }

    }


