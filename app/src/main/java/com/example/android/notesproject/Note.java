package com.example.android.notesproject;

import java.util.Date;

public class Note {
    private String id;
    private String title;
    private String Description;
    private Long date;
    private String notebookID;


    public Note() {
    }

    public Note(String id, String title, String description, Long date, String notebookID) {
        this.id = id;
        this.title = title;
        Description = description;
        this.date = date;
        this.notebookID = notebookID;
    }

    public String getNotebookID() {
        return notebookID;
    }

    public void setNotebookID(String notebookID) {
        this.notebookID = notebookID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
