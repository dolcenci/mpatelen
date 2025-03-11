package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class applyforloan extends AppCompatActivity {


    EditText editText_name, editText_email;
    Button button_save;
    SharedPreferences sharedPreferences;

    private static final  String SHARED_PREF_NAME = "mypref";
    private static final  String KEY_NAME = "name";
    private static final  String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyforloan);

    editText_name = findViewById(R.id.editTextText);
    editText_email = findViewById(R.id.editTextText2);
    button_save = findViewById(R.id.button);

    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

    button_save.setOnClickListener(new View.OnClickListener(){
    @Override
                public void onClick(View v){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_NAME, editText_name.getText().toString());
            editor.putString(KEY_EMAIL, editText_email.getText().toString());
            editor.apply();

            Intent intent = new Intent(applyforloan.this, loanstatus.class);
            startActivity(intent);

        }


    });


    }
}