package com.hfad.labnote;

public class Note {
    private String title;
    private String status;
    private String description;

    public Note(String t, String s, String d) {
       title = t;
       status = s;
       description = d;
    }

    public String getTitle(){
        return title;
    }

    public String getStatus(){
        return status;
    }

    public String getDescription(){
        return description;
    }



}
