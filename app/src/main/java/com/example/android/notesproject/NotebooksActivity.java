package com.example.android.notesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotebooksActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    String userUID;
    ArrayList<Notebook> notebookArrayList;
    ArrayList<String> notebookNamesArrayList;
    ArrayList<Integer> notebookImageArrayList ;
    GridView grid;
    GridAdapter adapter;
    Notebook notebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebooks);

        notebookArrayList = new ArrayList<Notebook>();
        notebookNamesArrayList = new ArrayList<String>();
        notebookImageArrayList = new ArrayList<Integer>();



        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notebook");
        userUID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        ValueEventListener notebookListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot notebookSnapshot : dataSnapshot.getChildren()) {
                    notebook = notebookSnapshot.getValue(Notebook.class);
                    if(notebook.getUserID().equals(userUID)){
                        notebookArrayList.add(notebook);
                        notebookNamesArrayList.add(notebook.getName());
                        notebookImageArrayList.add(notebook.getImageID());

                }
                    grid = (GridView)findViewById(R.id.gridview);

                    adapter = new GridAdapter(getApplicationContext(), notebookNamesArrayList,notebookImageArrayList);
                    grid.setAdapter(adapter);
                    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                           Intent intent = new Intent(NotebooksActivity.this,NotesActivity.class);
                           intent.putExtra("notebookID",notebookArrayList.get(i).getId());
                           startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Error", "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(NotebooksActivity.this, "Failed to load Notebooks.",
                        Toast.LENGTH_SHORT).show();
            }
        };
        databaseReference.addValueEventListener(notebookListener);

        Log.d("NotebookList", notebookArrayList.toString());

        findViewById(R.id.material_design_floating_action_menu_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (NotebooksActivity.this,AddNewNotebookActivity.class);
                startActivity(intent);
            }
        });



    }


}