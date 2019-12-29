package com.example.android.notesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {
    String notebookID;
    DatabaseReference databaseReference;
    ArrayList<Note> noteArrayList;
    FloatingActionButton floatingActionButton;
    boolean hasNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        notebookID  = getIntent().getStringExtra("notebookID");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Note");
        noteArrayList = new ArrayList<Note>();
        hasNotes =false;

        floatingActionButton = (FloatingActionButton)findViewById(R.id.material_design_floating_action_menu_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, AddNewNoteActivity.class);
                intent.putExtra("notebookID",notebookID);
                startActivity(intent);

            }
        });


        ValueEventListener noteListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                     Note note = noteSnapshot.getValue(Note.class);
                    if( (note != null)&& (note.getNotebookID().equals(notebookID))){
                        noteArrayList.add(note);
                        hasNotes =true;

                    }else{
                        Intent intent = new Intent(NotesActivity.this, EmptyNoteActivity.class);
                        intent.putExtra("notebookID",notebookID);
                        startActivity(intent);
                    }

   /*                 grid = (GridView)findViewById(R.id.gridview);

                    adapter = new GridAdapter(getApplicationContext(), notebookNamesArrayList,notebookImageArrayList);
                    grid.setAdapter(adapter);
                    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent = new Intent(NotebooksActivity.this,NotesActivity.class);
                            intent.putExtra("notebookID",notebookArrayList.get(i).getId());
                            startActivity(intent);
                        }
                    });*/
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Error", "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(NotesActivity.this, "Failed to load Notes.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        databaseReference.addValueEventListener(noteListener);



    }
}
