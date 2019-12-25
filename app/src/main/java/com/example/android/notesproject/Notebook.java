package com.example.android.notesproject;

import java.util.ArrayList;
import java.util.Date;

public class Notebook {

    private String color;
    private String name;
    private ArrayList<Note> listOfNotes;


    public Notebook(String color, String name) {
        this.color = color;
        listOfNotes =new ArrayList<Note>();
    }

    public void addNote (Note note){
        listOfNotes.add(note);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Note> getListOfNotes() {
        return listOfNotes;
    }

    public void setListOfNotes(ArrayList<Note> listOfNotes) {
        this.listOfNotes = listOfNotes;
    }
}
