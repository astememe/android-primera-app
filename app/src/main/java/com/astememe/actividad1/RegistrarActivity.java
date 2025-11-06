package com.astememe.actividad1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.textfield.TextInputLayout;

import org.mindrot.jbcrypt.BCrypt;


public class RegistrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        TextInputLayout correo = findViewById(R.id.correo);
        TextInputLayout contrasena = findViewById(R.id.contrasena);
        TextInputLayout nombre = findViewById(R.id.nombre);
        TextInputLayout contrasena_verificar = findViewById(R.id.contrasena_verificar);
        Button boton_registrar = findViewById(R.id.boton_registrar);
        ImageView logo = findViewById(R.id.logo);
        Glide.with(this)
                .load(R.drawable.calendario)
                .into(logo);

        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contrasenaHasheada = BCrypt.hashpw(String.valueOf(contrasena.getEditText().getText()), BCrypt.gensalt());
                boolean canContinue = true;
                contrasena.setErrorEnabled(false);
                correo.setErrorEnabled(false);
                nombre.setErrorEnabled(false);
                contrasena_verificar.setErrorEnabled(false);
                if (String.valueOf(correo.getEditText().getText()).isEmpty()) {
                    correo.setErrorEnabled(true);
                    correo.setError("Se necesita un correo.");
                    canContinue = false;
                } else if (!String.valueOf(correo.getEditText().getText()).endsWith("@gmail.com")) {
                    correo.setErrorEnabled(true);
                    correo.setError("El correo debe ser de gmail");
                    canContinue = false;
                }

                if (String.valueOf(contrasena.getEditText().getText()).isEmpty()) {
                    contrasena.setErrorEnabled(true);
                    contrasena.setError("Se necesita una contraseña");
                    canContinue = false;
                } else if (!String.valueOf(contrasena_verificar.getEditText().getText()).equals(String.valueOf(contrasena.getEditText().getText()))) {
                    contrasena_verificar.setErrorEnabled(true);
                    contrasena_verificar.setError("Las contraseñas no coinciden");
                    canContinue = false;
                }

                if (String.valueOf(nombre.getEditText().getText()).isEmpty()) {
                    nombre.setErrorEnabled(true);
                    nombre.setError("Se necesita un nombre de usuario");
                    canContinue = false;
                }

                if (canContinue) {
                    editor.putString("nombre", String.valueOf(nombre.getEditText().getText()));
                    editor.putString("correo", String.valueOf(correo.getEditText().getText()));
                    editor.putString("contrasena", contrasenaHasheada);
                    editor.apply();
                    Intent intent = new Intent(RegistrarActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}