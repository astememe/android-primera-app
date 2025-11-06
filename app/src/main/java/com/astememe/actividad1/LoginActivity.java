package com.astememe.actividad1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import org.mindrot.jbcrypt.BCrypt;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button boton_login = findViewById(R.id.boton_entrar);
        TextView boton_register = findViewById(R.id.boton_registrar);
        TextInputLayout correo = findViewById(R.id.correo);
        TextInputLayout contrasena = findViewById(R.id.contrasena);
        TextInputLayout nombre = findViewById(R.id.nombre);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String contrasenaHasheada = sharedPreferences.getString("contrasena", "");

        boton_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean canContinue = true;
                contrasena.setErrorEnabled(false);
                correo.setErrorEnabled(false);
                nombre.setErrorEnabled(false);
                if (String.valueOf(correo.getEditText().getText()).isEmpty()) {
                    correo.setErrorEnabled(true);
                    correo.setError("Se necesita un correo.");
                    canContinue = false;
                } else if (!String.valueOf(correo.getEditText().getText()).endsWith("@gmail.com")) {
                    correo.setErrorEnabled(true);
                    correo.setError("El correo debe ser de gmail");
                    canContinue = false;
                } else if (!String.valueOf(correo.getEditText().getText()).equals(sharedPreferences.getString("correo", ""))) {
                    correo.setErrorEnabled(true);
                    correo.setError("El correo no es correcto.");
                    canContinue = false;
                }

                if (String.valueOf(contrasena.getEditText().getText()).isEmpty()) {
                    contrasena.setErrorEnabled(true);
                    contrasena.setError("Se necesita una contraseña");
                    canContinue = false;
                } else if (!BCrypt.checkpw(String.valueOf(contrasena.getEditText().getText()), contrasenaHasheada)) {
                    contrasena.setErrorEnabled(true);
                    contrasena.setError("Contraseña incorrecta");
                    canContinue = false;
                }

                if (String.valueOf(nombre.getEditText().getText()).isEmpty()) {
                    nombre.setErrorEnabled(true);
                    nombre.setError("Se necesita un nombre de usuario");
                    canContinue = false;
                } else if (!String.valueOf(nombre.getEditText().getText()).equals(sharedPreferences.getString("nombre", ""))) {
                    nombre.setErrorEnabled(true);
                    nombre.setError("El nombre no es correcto.");
                }

                if (canContinue) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("nombre", String.valueOf(nombre.getEditText().getText()));
                    startActivity(intent);
                }
            }
        });

        boton_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });
    }
}