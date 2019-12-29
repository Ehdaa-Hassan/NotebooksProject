package com.example.android.notesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddNewNoteActivity extends AppCompatActivity {
    EditText title;
    EditText description;
    TextView cancel;
    Long createdDate;
    DatabaseReference databaseReference;
    Button save;
    String notebookID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
         notebookID = getIntent().getStringExtra("notebookID");
        createdDate = new Date().getTime();

        save = (Button) findViewById(R.id.save);
        databaseReference = FirebaseDatabase.getInstance().getReference("Note");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((title.getText() != null)&&(description.getText() != null)){

                    String noteId = databaseReference.push().getKey();
                    Note note = new Note(noteId,title.getText().toString(),description.getText().toString(),createdDate,notebookID);
                    databaseReference.child(noteId).setValue(note);

                    Intent intent = new Intent(AddNewNoteActivity.this,NotesActivity.class);
                    startActivity(intent);

                }

            }
        });








         cancel = (TextView) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText("");
                description.setText("");

            }
        });

    }
}
