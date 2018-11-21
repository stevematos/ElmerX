package com.elmerx.taxisanmarcos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.elmerx.taxisanmarcos.conexion.ApiService;

public class ModificarDatos extends AppCompatActivity {

    private ApiService apiService;
    private final String TAG = RegistroActivity.class.getSimpleName();

    EditText edNombresUp;
    EditText edApellidosUp;
    EditText edCelularUp;
    EditText edFacultadUp;
    EditText edCodigoAlumnoUp;
    EditText edNuevoUsuarioUp;
    EditText edNuevoUsuarioPassUp;

    int id_usuario;
    Toast toast;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos);

        edNombresUp = findViewById(R.id.edNombresUP);
        edApellidosUp = findViewById(R.id.edApellidosUP);
        edCelularUp = findViewById(R.id.edCelularUP);
        edFacultadUp = findViewById(R.id.edFacultadUP);
        edCodigoAlumnoUp = findViewById(R.id.edCodigoAlumnoUP);
        edNuevoUsuarioUp = findViewById(R.id.edUsuarioUp);
        edNuevoUsuarioPassUp = findViewById(R.id.edPasswordUP);

    }
}
