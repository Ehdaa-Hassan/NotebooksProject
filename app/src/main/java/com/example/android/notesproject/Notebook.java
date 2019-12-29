package com.example.android.notesproject;

public class Notebook {

    private String id;
    private String color;
    private int imageID;
    private String name;
    private String userID;

    public Notebook() {
    }

    public Notebook(String id, String color, String name, String userID) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        switch (color){
            case"note1": imageID = R.drawable.note1;
                break;
            case"note2": imageID = R.drawable.note2;
                break;
            case"note3": imageID = R.drawable.note3;
                break;
            case"note4": imageID = R.drawable.note4;
                break;
            case"note5": imageID = R.drawable.note5;
                break;
            case"note6": imageID = R.drawable.note6;
                break;
            case"note7": imageID = R.drawable.note7;
                break;
            case"note8": imageID = R.drawable.note8;
                break;
            case"note9": imageID = R.drawable.note9;
                break;
            case"note10":imageID = R.drawable.note10;
                break;
            case"note11":imageID = R.drawable.note11;
                break;
            case"note12": imageID = R.drawable.note12;
                break;

        }

    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id='" + id + '\'' +
                ", color=" + color +
                ", name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
