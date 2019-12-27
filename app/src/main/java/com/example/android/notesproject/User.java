package com.example.android.notesproject;

public class User {
    String uID;
    String email;

    public User(String uID, String email) {
        this.uID = uID;
        this.email = email;
    }

    public User() {
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID='" + uID + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
