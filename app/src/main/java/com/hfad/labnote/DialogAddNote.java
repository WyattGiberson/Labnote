package com.hfad.labnote;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class DialogAddNote extends DialogFragment {

    private ArrayList<Note> noteList;

    public DialogAddNote(ArrayList<Note> n){
        noteList = n;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_item, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        Button btnAdd = dialogView.findViewById(R.id.btnSave);
        Button btnClose = dialogView.findViewById(R.id.btnClose);
        TextInputLayout description = dialogView.findViewById(R.id.txtInputLayoutDesc);
        TextInputLayout title = dialogView.findViewById(R.id.txtInputLayoutTitle);
        RadioButton optIdea = dialogView.findViewById(R.id.ideaBtn);
        RadioButton optToDo = dialogView.findViewById(R.id.toDoBtn);
        RadioButton optImp = dialogView.findViewById(R.id.rbImp);
        RadioGroup btnChoices = dialogView.findViewById(R.id.radioGroup);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(optIdea.isChecked()){
                    noteList.add(new Note(title.getEditText().getText().toString(),
                            description.getEditText().getText().toString(), "Idea"));
                }
                else if(optImp.isChecked()) {
                    noteList.add(new Note(title.getEditText().getText().toString(),
                            description.getEditText().getText().toString(), "Imp"));
                }
                else if(optToDo.isChecked()) {
                    noteList.add(new Note(title.getEditText().getText().toString(),
                            description.getEditText().getText().toString(), "To Do"));
                }
                else {
                    Toast.makeText(getActivity(),"Please Select an option for type.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        builder.setView(dialogView);

        return builder.create();
    }
}
