package com.example.myapplication;

import static android.content.ContentValues.TAG;

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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {



    FirebaseAuth mAuth;
    ProgressBar progressBar;

    FirebaseFirestore fstore;
    String userID;

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
    }

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        EditText editText_fullname = findViewById(R.id.editTextText3);
        EditText editText_phone = findViewById(R.id.editTextText4);
        EditText editText_email = findViewById(R.id.editTextText5);
        EditText editText_password = findViewById(R.id.editTextText6);
        Button button_signUp = findViewById(R.id.button8);
        TextView textView = findViewById(R.id.textView15);



        textView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(getApplicationContext(), login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );


        progressBar = findViewById(R.id.progressBar);

        button_signUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    progressBar.setVisibility(View.VISIBLE);

                    String fullname, phone, email, password;
                        fullname = String.valueOf(editText_fullname.getText());
                    email = String.valueOf(editText_email.getText());
                        password = String.valueOf(editText_password.getText());
                        phone = String.valueOf(editText_phone.getText());


                        progressBar.setVisibility(View.GONE);
                    if(TextUtils.isEmpty(email)){

                        Toast.makeText(signup.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                   return;
                    }

                        if(TextUtils.isEmpty(password)){
                            Toast.makeText(signup.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                         return;
                        }


                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        //code to delete
                                        userID = mAuth.getCurrentUser().getUid();  //SOME PROGESS AS WEVE ALREADY GOTTEN THE USER ID FROM GOOGLE
                                        DocumentReference documentReference = fstore.collection("users").document(userID);
                                        Map<String, Object> user = new HashMap<>();
                                        user.put("fname", fullname);
                                        user.put("email", email);
                                        user.put("phone", phone);
                                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            //unused - replace the voids name
                                            @Override
                                            public void onSuccess(Void aVouid) {
                                                Log.d( TAG , "HI DAWG: " + userID );


                                            }
                                        });


                                        //code to delete end
                                        if (task.isSuccessful()) {
                                            Toast.makeText(signup.this, "Account Created.",
                                                    Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), login.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            // If sign in fails, display a message to the user.

                                            Toast.makeText(signup.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });


                    }
                }

        );

    }
}