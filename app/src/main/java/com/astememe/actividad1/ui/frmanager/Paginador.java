package com.astememe.actividad1.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.astememe.actividad1.mainfr.Tareas;
import com.astememe.actividad1.mainfr.Tareas_Completadas;

public class Paginador extends FragmentPagerAdapter {

    private final Context mcontext;
    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mcontext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tareas();
            case 1:
                return new Tareas_Completadas();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
