package com.astememe.actividad1.mainfr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.astememe.actividad1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Tareas_Completadas extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista_tareas_completadas = inflater.inflate(R.layout.fragment_tareas_completadas, container, false);


        ArrayList<ConstraintLayout> tareas_completadas = new ArrayList<>(Arrays.asList(
                vista_tareas_completadas.findViewById(R.id.tarea_completada_1),
                vista_tareas_completadas.findViewById(R.id.tarea_completada_2),
                vista_tareas_completadas.findViewById(R.id.tarea_completada_3),
                vista_tareas_completadas.findViewById(R.id.tarea_completada_4),
                vista_tareas_completadas.findViewById(R.id.tarea_completada_5),
                vista_tareas_completadas.findViewById(R.id.tarea_completada_6)
        ));

        for (ConstraintLayout tarea_completada: tareas_completadas) {
            tarea_completada.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrar_alerta(tarea_completada.findViewById(R.id.tarjeta_completada).findViewById(R.id.tarjeta).findViewById(R.id.nombre_tarea));
                }
            });
        }

        return vista_tareas_completadas;
    }

    public void mostrar_alerta(TextView nombre_tarea_completada) {
        final EditText nombrenuevo = new EditText(getContext());
        System.out.println(nombre_tarea_completada.getText().toString());
        new AlertDialog.Builder(getContext())
                .setTitle("Cambiar nombre de tarea")
                .setMessage("Introduzca el nuevo nombre")
                .setView(nombrenuevo)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nombre_tarea_completada.setText(nombrenuevo.getText().toString());
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
