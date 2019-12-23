package com.example.android.notesproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
         auth = FirebaseAuth.getInstance();

        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        Button recoverEmail = (Button)findViewById(R.id.recoverEmail);
        recoverEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 EditText email =(EditText) findViewById(R.id.email);
                 if(email!=null) {
                     String emailAddress = email.getText().toString();

                     auth.sendPasswordResetEmail(emailAddress)
                             .addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task) {
                                     if (task.isSuccessful()) {
                                         Intent intent = new Intent(ForgotPasswordActivity.this, CheckEmailActivity.class);
                                         startActivity(intent);
                                     }
                                 }
                             });
                 }



            }
        });
    }
}
