package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class loanstatus extends AppCompatActivity {

    TextView textView_name, textView_email;


    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loanstatus);

        textView_name =findViewById(R.id.textView2);
                textView_email  =findViewById(R.id.textView3);

        ImageButton button_back = findViewById(R.id.imageButton);

        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(loanstatus.this, MainActivity.class);
                startActivity(intent);

            }
        });


       sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

       String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);


        if(name != null || email != null){
            textView_name.setText("R" + name );
            textView_email.setText(email );
        }


    }
}