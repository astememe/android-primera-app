package com.astememe.actividad1.mainfr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.astememe.actividad1.R;
import com.google.android.material.textview.MaterialTextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tareas extends Fragment {
    ArrayList<Integer> colores;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentTareas = inflater.inflate(R.layout.fragment_tareas, container, false);

        ArrayList<ConstraintLayout> tareas = new ArrayList<>(Arrays.asList(
                fragmentTareas.findViewById(R.id.tarjeta1),
                fragmentTareas.findViewById(R.id.tarjeta2),
                fragmentTareas.findViewById(R.id.tarjeta3),
                fragmentTareas.findViewById(R.id.tarjeta4),
                fragmentTareas.findViewById(R.id.tarjeta5)
        ));

        colores = new ArrayList<>(Arrays.asList(
                R.color.a,
                R.color.a2,
                R.color.a3,
                R.color.a4,
                R.color.a5
        ));

        for (ConstraintLayout tarea: tareas) {
            tarea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarError(tarea.findViewById(R.id.tarjeta).findViewById(R.id.fondo_tarjeta).findViewById(R.id.nombre));
                }
            });
        }

        return fragmentTareas;
    }

    public void mostrarError(MaterialTextView tarea) {
        new AlertDialog.Builder(getContext())
                .setTitle("Cambiar color")
                .setMessage("Al aceptar cambiará el color de la tarea")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int color = colores.get((int) (0*(1.0 - Math.random()/Math.nextDown(1.0)) + 4*Math.random()/Math.nextDown(1.0)));
                        tarea.setTextColor(getContext().getColor(color));
                    }
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    Toast.makeText(getContext(), "Fuera de aquí", Toast.LENGTH_SHORT).show();
                })
                .setIcon(R.drawable.calendario)
                .show();
    }
}
