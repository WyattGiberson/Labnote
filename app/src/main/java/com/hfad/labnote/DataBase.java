package com.hfad.labnote;

import java.util.ArrayList;

public class DataBase {

    private static ArrayList<Note> notes;

    public static ArrayList<Note> getNotes(){
        if(notes == null){
            loadData();
        }
        return notes;
    }

    private static void loadData(){
       notes = new ArrayList<Note>();

        ArrayList<String> title = new ArrayList<String>();
        title.add("Study for Calc Final");
        title.add("Study for Bio Final");
        title.add("Study for CompSci Final");
        title.add("Study for Art Final");
        title.add("Study for Chem Final");
        title.add("Study for Multi Final");
        title.add("Study for Film Final");
        title.add("Study for Game Final");
        title.add("Study for Lan Final");
        title.add("Study for Hist Final");

        ArrayList<String> status = new ArrayList<String>();
        status.add("Idea");
        status.add("started");
        status.add("Complete");
        status.add("In Progress");
        status.add("Working");
        status.add("Computing");
        status.add("Fighting");
        status.add("Writing");
        status.add("Gaming");
        status.add("Studying");


        ArrayList<String> desc = new ArrayList<String>();
        desc.add("Exam Friday 16th - review now");
        desc.add("Exam Thursday 10th - keep reviewing");
        desc.add("Exam Monday 11th - start soon");
        desc.add("Exam Tuesday 23th - almost done");
        desc.add("Exam Saturday 30th - create worksheet");
        desc.add("Exam Friday 27th - finish project");
        desc.add("Exam Tuesday 14th - Submit Email");
        desc.add("Exam Monday 12th - Ask for help");
        desc.add("Exam Saturday 5th - Draw and Win");
        desc.add("Exam Thursday 3rd - Read Book");



        for (int i=0; i < title.size(); i++){
            notes.add(new Note(title.get(i), status.get(i), desc.get(i)));
        }
    }
}

