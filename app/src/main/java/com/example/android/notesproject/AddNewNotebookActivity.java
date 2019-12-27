package com.example.android.notesproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AddNewNotebookActivity extends AppCompatActivity {
    ImageView chosenNoteColor;
    EditText nameEditText;
    TextView cancel;
    String color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_notebook);

        color="note1";
         chosenNoteColor = (ImageView) findViewById(R.id.chosen_note);

        final Button note1 = (Button) findViewById(R.id.note1);
        Button note2 = (Button) findViewById(R.id.note2);
        Button note3 = (Button) findViewById(R.id.note3);
        Button note4 = (Button) findViewById(R.id.note4);
        Button note5 = (Button) findViewById(R.id.note5);
        Button note6 = (Button) findViewById(R.id.note6);
        Button note7 = (Button) findViewById(R.id.note7);
        Button note8 = (Button) findViewById(R.id.note8);
        Button note9 = (Button) findViewById(R.id.note9);
        Button note10 = (Button) findViewById(R.id.note10);
        Button note11 = (Button) findViewById(R.id.note11);
        Button note12 = (Button) findViewById(R.id.note12);
        Button saveNoteBook = (Button) findViewById(R.id.save);
        nameEditText = (EditText) findViewById(R.id.name);
        TextView cancel = (TextView) findViewById(R.id.cancel);

        saveNoteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(nameEditText.getText() != null){
                   Notebook notebook = new Notebook(color, nameEditText.getText().toString());





               }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameEditText.setText("");
                chosenNoteColor.setImageResource(R.drawable.note1);
                color="note1";

            }
        });

        note1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note1);
                color="note1";

            }
        });

        note2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note2);
                color="note2";

            }
        });

        note3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note3);
                color="note3";

            }
        });

        note4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note4);
                color="note4";

            }
        });

        note5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note5);
                color="note5";

            }
        });

        note6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note6);
                color="note6";

            }
        });

        note7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note7);
                color="note7";

            }
        });

        note8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note8);
                color="note8";

            }
        });

        note9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note9);
                color="note9";

            }
        });
        note10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note10);
                color="note10";

            }
        });

        note11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note11);
                color="note11";

            }
        });

        note12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenNoteColor.setImageResource(R.drawable.note12);
                color="note12";

            }
        });

    }
}
