package com.example.fahid.routineproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView info;
    private int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

   Name =(EditText)findViewById(R.id.name);
   Password=(EditText)findViewById(R.id.pass);
   Login=(Button)findViewById(R.id.b1);
   info=(TextView)findViewById(R.id.info);
        info.setText("No of attempts Remaining:5");
        Login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                validate(Name.getText().toString(),Password.getText().toString());
            }

        });

    }
     private void validate(String userName,String userPassword){
         if((userName.equals("ice"))&&(userPassword.equals("1234"))){

             Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
             startActivity(intent);
         }
         else {
             counter--;
             info.setText("No of attempts remaining:"+String.valueOf(counter));
             Toast.makeText(Main2Activity.this,"Wrong password",Toast.LENGTH_SHORT).show();
             if(counter==0){
                 Login.setEnabled(false);
             }

         }
     }


}
