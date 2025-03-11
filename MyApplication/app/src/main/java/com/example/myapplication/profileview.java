package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class profileview extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);

        TextView editText_name = findViewById(R.id.textView18);
        TextView editText_email = findViewById(R.id.textView19);
        TextView editText_number = findViewById(R.id.textView20);
        TextView editText_adress = findViewById(R.id.textView21);
        TextView editText_date = findViewById(R.id.textView22);

        Button button_edit = findViewById(R.id.button12);

        button_edit.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(getApplicationContext(), profilepage.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
        );

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        userId = mAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fstore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
             editText_number.setText(documentSnapshot.getString("phone"));
                editText_name.setText(documentSnapshot.getString("fname"));
                editText_email.setText(documentSnapshot.getString("email"));
            }
        });


    }
}