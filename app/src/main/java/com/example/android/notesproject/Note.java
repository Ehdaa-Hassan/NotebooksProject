package com.example.android.notesproject;

import java.util.Date;

public class Note {
    String title;
    String Description;
    Date date;

    public Note(String title, String description, Date date) {
        this.title = title;
        Description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
