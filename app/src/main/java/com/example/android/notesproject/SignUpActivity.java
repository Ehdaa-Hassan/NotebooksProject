package com.example.android.notesproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth authentication;
    EditText email,password;
    Button signup;
    boolean isUserSignedIn;
    private DatabaseReference database;
    FirebaseUser firebaceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView exit = (ImageView) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);
        authentication= FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference("Users");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((email!=null)&&(password!=null)){
                     String  emailValue = email.getText().toString();
                     String  passwardValue = password.getText().toString();
                    authentication.createUserWithEmailAndPassword(emailValue, passwardValue)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        firebaceUser = FirebaseAuth.getInstance().getCurrentUser();
                                        String uid = firebaceUser.getUid();
                                        String email = firebaceUser.getEmail();
                                        User user = new User(uid,email);
                                       database.child(uid).setValue(user);

                                        Intent intent = new Intent(SignUpActivity.this, EmptyNotebookActivity.class);
                                        startActivity(intent);

                                    } else {
                                        Log.w("Error", "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });

                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter your Email and/or password",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        firebaceUser = authentication.getCurrentUser();
        if(firebaceUser!=null){
            isUserSignedIn = true;
        }
    }
}
