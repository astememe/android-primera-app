package com.astememe.actividad1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.astememe.actividad1.databinding.ActivityMainBinding;
import com.astememe.actividad1.ui.frmanager.Paginador;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.coralViewPager;
        viewPager.setAdapter(paginador);


        TextView saludo = findViewById(R.id.saludo);

        //Bundle bundle = getIntent().getExtras();
        //String nombre = String.valueOf((bundle.getString("nombre")));
        //saludo.setText(new String("Hola " + nombre));
    }
}