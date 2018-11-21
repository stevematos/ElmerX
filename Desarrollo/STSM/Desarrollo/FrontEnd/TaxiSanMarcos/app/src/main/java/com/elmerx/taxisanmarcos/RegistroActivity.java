package com.elmerx.taxisanmarcos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.elmerx.taxisanmarcos.conexion.ApiAdapter;
import com.elmerx.taxisanmarcos.conexion.ApiService;
import com.elmerx.taxisanmarcos.modelo.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    private ApiService apiService;
    private final String TAG = RegistroActivity.class.getSimpleName();

    ArrayList<String> listaFacultad;
    Spinner spinner_lista_facultad;

    EditText edNombres;
    EditText edApellidos;
    EditText edCelular;
    int id_facultad = 0;
    EditText edCodigoAlumno;
    EditText edNuevoUsuario;
    EditText edNuevoUsuarioPass;

    Toast toast;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edNombres = findViewById(R.id.edNombres);
        edApellidos = findViewById(R.id.edApellidos);
        edCelular = findViewById(R.id.edCelular);
        edCodigoAlumno = findViewById(R.id.edCodigoAlumno);
        edNuevoUsuario = findViewById(R.id.edNuevoUsuario);
        edNuevoUsuarioPass = findViewById(R.id.edNuevoUsuarioPass);

        listaFacultad = new ArrayList<String>();
        listaFacultad.add("Facultad");
        listaFacultad.add("Ingenieria e informatica");
        listaFacultad.add("Letras y Humanidades");

        ArrayAdapter adapter = new ArrayAdapter(RegistroActivity.this,
                android.R.layout.simple_dropdown_item_1line, listaFacultad);

        spinner_lista_facultad = findViewById(R.id.spinnerFacultad);
        spinner_lista_facultad.setAdapter(adapter);

        spinner_lista_facultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0){
                    id_facultad = position;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void registrar(View view) {
        if(edNombres.getText().toString().isEmpty() ||
                edApellidos.getText().toString().isEmpty() ||
                edCelular.getText().toString().isEmpty() ||
                edCodigoAlumno.getText().toString().isEmpty() ||
                edNuevoUsuario.getText().toString().isEmpty() ||
                edNuevoUsuarioPass.getText().toString().isEmpty() ||
                id_facultad == 0){
            toast = Toast.makeText(RegistroActivity.this, "Faltan datos!", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setIdUsuario(Integer.valueOf(edNuevoUsuarioPass.getText().toString()));
            usuarioNuevo.setNombre(edNombres.getText().toString());
            usuarioNuevo.setApellidos(edApellidos.getText().toString());
            usuarioNuevo.setCelular(edCelular.getText().toString());
            usuarioNuevo.setIdFacultad(id_facultad);
            usuarioNuevo.setCodAlumno(edCodigoAlumno.getText().toString());
            usuarioNuevo.setUsuario(edNuevoUsuario.getText().toString());
            usuarioNuevo.setContrasena(edNuevoUsuarioPass.getText().toString());
            registrarUsuario(usuarioNuevo);
        }
    }

    private void registrarUsuario(Usuario request) {
        apiService = ApiAdapter.getInstance().createService(ApiService.class);
        //apiService = ApiAdapter.createService(ApiService.class);
        Call<Usuario> call = apiService.registrarUsuario(request);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    toast = Toast.makeText(RegistroActivity.this, "Bienvenido", Toast.LENGTH_SHORT);
                    toast.show();
                    intent = new Intent(RegistroActivity.this, MenuUsuario.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e(TAG, "PASO ALGO:\n Unable to submit post to API.");
            }
        });
    }
}
