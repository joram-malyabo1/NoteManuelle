package com.example.notemanuelle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ApercuNote extends AppCompatActivity {

    TextView idDateNote, idNumeroNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apercu_note);

        idDateNote=findViewById(R.id.idDateNote);
        idNumeroNote = findViewById(R.id.idNumeroNote);

        String getIdateNote = idDateNote.getText().toString();
        String getIdnumeroNote =idNumeroNote.getText().toString();

        idDateNote.setText(StaticValues.DateNote);
        idNumeroNote.setText(StaticValues.numNote);
    }
}
