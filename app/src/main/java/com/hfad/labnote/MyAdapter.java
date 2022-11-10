package com.hfad.labnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Note> noteList;

    public MyAdapter(){
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


    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtStatus;
        private TextView txtDesc;
        private ImageView imvDele;
        private int currentPositionInList = -1;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            txtTitle = itemView.findViewById(R.id.tvTitle);
            txtStatus = itemView.findViewById(R.id.tvStatus);
            txtDesc = itemView.findViewById(R.id.tvDescription);
            imvDele = itemView.findViewById(R.id.imvDelete);

            imvDele.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteList.remove(currentPositionInList);
                    notifyItemChanged(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, noteList.size());
                }
            });
        }

        public void setData(Note vd, int position){
            txtTitle.setText(vd.getTitle());
            txtStatus.setText(vd.getStatus());
            txtDesc.setText(vd.getDescription());
            currentPositionInList = position;
        }
    }

}
