package com.elmerx.taxisanmarcos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    ArrayList<String> listaFacultad;
    Spinner spinner_lista_facultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        listaFacultad = new ArrayList<String>();
        listaFacultad.add("Facultad");
        listaFacultad.add("Ingenieria e informatica");
        listaFacultad.add("Letras y Humanidades");

        ArrayAdapter adapter = new ArrayAdapter(RegistroActivity.this,
                android.R.layout.simple_dropdown_item_1line, listaFacultad);

        spinner_lista_facultad = findViewById(R.id.spinnerFacultad);
        spinner_lista_facultad.setAdapter(adapter);
    }

}
