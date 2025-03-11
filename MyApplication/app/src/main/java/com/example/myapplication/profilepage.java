package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class profilepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);

        EditText editText_name = findViewById(R.id.editTextText9);
        EditText editText_email = findViewById(R.id.editTextText10);
        EditText editText_number = findViewById(R.id.editTextText11);
        EditText editText_adress = findViewById(R.id.editTextText12);
        EditText editText_date = findViewById(R.id.editTextText13);

        Button button_createProfile = findViewById(R.id.button11);


        String name, email, number, adress, date;
        name = String.valueOf(editText_name.getText());
        email = String.valueOf(editText_email.getText());
        number = String.valueOf(editText_number.getText());
        adress = String.valueOf(editText_adress.getText());
        date = String.valueOf(editText_date.getText());

        button_createProfile.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(getApplicationContext(), profileview.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );

    }
}