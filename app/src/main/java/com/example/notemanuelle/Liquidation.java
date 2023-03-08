package com.example.notemanuelle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Liquidation extends AppCompatActivity {

    Button btnNext, btnPrev;
    Spinner idDeviseliquidation;

    private EditText idDatedebut;

    String []deviseLiquidation = {"Selection Devise","US","FC"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidation);

        btnNext=findViewById(R.id.btnNext);
        btnPrev=findViewById(R.id.btnPrev);

        idDatedebut =findViewById(R.id.idDatedebut);

        idDeviseliquidation = findViewById(R.id.idDeviseliquidation);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(Liquidation.this, android.R.layout.simple_spinner_item,deviseLiquidation);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idDeviseliquidation.setAdapter(adapter);

        idDeviseliquidation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String val = parent.getItemAtPosition(position).toString();
                Toast.makeText(Liquidation.this, val, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int mounth = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        idDatedebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Liquidation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int mounth, int dayOfMounth) {
                        mounth = mounth+1;
                        String date = day+" / "+mounth+" / "+year;
                        idDatedebut.setText(date);
                    }
                },year, mounth, day);
                dialog.show();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Liquidation.this, Taxateur.class);
                startActivity(intent);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Liquidation.this, Article.class);
                onBackPressed();
            }
        });
    }
}
