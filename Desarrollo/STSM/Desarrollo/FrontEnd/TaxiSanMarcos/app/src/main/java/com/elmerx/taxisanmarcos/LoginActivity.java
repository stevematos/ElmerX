package com.elmerx.taxisanmarcos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Intent intent;

    EditText edUser;
    EditText edPassword;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUser= findViewById(R.id.edUser);
        edPassword = findViewById(R.id.edPassword);
    }

    public void redirectRegistro(View view) {
        intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

    public void redirectMain(View view) {
        /*if(edUser.getText().toString().isEmpty() ||
                edPassword.getText().toString().isEmpty()){
            toast = Toast.makeText(LoginActivity.this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT);
            toast.show();

        }else{*/
            intent = new Intent(LoginActivity.this, MenuUsuario.class);
            startActivity(intent);
        //}
    }
}
