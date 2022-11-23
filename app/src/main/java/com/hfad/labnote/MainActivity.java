package com.hfad.labnote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {


    private FloatingActionButton imvAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imvAdd = findViewById(R.id.fabAdd);

        imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddNote dialog = new DialogAddNote(DataBase.getNotes());
                dialog.show(getSupportFragmentManager(), "");
            }
        });

        setUpRecyclerView();
    }

    private void setUpRecyclerView(){

        RecyclerView rv = findViewById(R.id.recyclerView);

        //adapter
        NoteAdapter adapter = new NoteAdapter();
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

    }


}