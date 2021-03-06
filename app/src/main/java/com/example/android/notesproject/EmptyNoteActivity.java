package com.example.android.notesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;

public class EmptyNoteActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    String notebookID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_empty_note);
        notebookID  = getIntent().getStringExtra("notebookID");

        floatingActionButton = (FloatingActionButton)findViewById(R.id.material_design_floating_action_menu_item);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EmptyNoteActivity.this, AddNewNoteActivity.class);
                intent.putExtra("notebookID",notebookID);
                startActivity(intent);

            }
        });
    }
}
