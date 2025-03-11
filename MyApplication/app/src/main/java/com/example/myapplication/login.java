package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    FirebaseAuth mAuth;
    ProgressBar progressBar;

    /*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        EditText editText_email = findViewById(R.id.editTextText7);
        EditText editText_password = findViewById(R.id.editTextText8);
       TextView textView = findViewById(R.id.textView16);
       Button button_Login = findViewById(R.id.button9);

       progressBar = findViewById(R.id.progressBar);


        textView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(getApplicationContext(), signup.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                    );

        button_Login.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            progressBar.setVisibility(View.VISIBLE);

                                            String email, password;
                                            email = String.valueOf(editText_email.getText());
                                            password = String.valueOf(editText_password.getText());

                                            progressBar.setVisibility(View.GONE);
                                            if(TextUtils.isEmpty(email)){

                                                Toast.makeText(login.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                                                return;
                                            }

                                            if(TextUtils.isEmpty(password)){
                                                Toast.makeText(login.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                                                return;
                                            }

                                            mAuth.signInWithEmailAndPassword(email, password)
                                                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<AuthResult> task) {

                                                            progressBar.setVisibility(View.GONE);

                                                            if (task.isSuccessful()) {
                                                                // Sign in success, update UI with the signed-in user's information

                                                                Toast.makeText(login.this, "Login Successful.",
                                                                        Toast.LENGTH_SHORT).show();

                                                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                                startActivity(intent);
                                                                finish();

                                                            } else {
                                                                // If sign in fails, display a message to the user.

                                                                Toast.makeText(login.this, "Authentication failed.",
                                                                        Toast.LENGTH_SHORT).show();

                                                            }
                                                        }
                                                    });






                                        }
                                    }
        );



    }
}