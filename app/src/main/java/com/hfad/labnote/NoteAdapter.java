package com.hfad.labnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private ArrayList<Note> noteList;

    public NoteAdapter(){
        noteList = DataBase.getNotes();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row_item, parent, false);

        return new MyViewHolder(view);

    }

    //Binds data to an empty row view
    //position = index in the list you want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){

        Note nl = noteList.get(position);
        holder.setData(nl, position);

    }


    @Override
    public int getItemCount(){
        return noteList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitle;
        private TextView txtStatus;
        private TextView txtDesc;
        private ImageView imvDelete;


        private int currentPositionInList = -1;
        private Note currentNote = null;

        public MyViewHolder(@NonNull View view){
            super(view);

            txtTitle = view.findViewById(R.id.tvTitle);
            txtStatus = view.findViewById(R.id.tvStatus);
            txtDesc = view.findViewById(R.id.tvDescription);
            imvDelete = view.findViewById(R.id.imvDelete);


            imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteList.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, noteList.size());
                }
            });

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        public void setData(Note n, int position){
            txtTitle.setText(n.getTitle());
            txtStatus.setText(n.getStatus());
            txtDesc.setText(n.getDescription());
            currentPositionInList = position;
            currentNote = n;
        }

        @Override
        public void onClick(View view) {
            DialogAddNote dialog = new DialogAddNote(noteList);
            FragmentActivity fa = (FragmentActivity) view.getContext();
            FragmentManager fm = fa.getSupportFragmentManager();
            dialog.show(fm, "");
        }
    }

}
