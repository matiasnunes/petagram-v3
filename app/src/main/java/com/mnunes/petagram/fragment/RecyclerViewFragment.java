package com.mnunes.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mnunes.petagram.R;
import com.mnunes.petagram.adapter.MascotaAdaptador;
import com.mnunes.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment  extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        ArrayList<String> nombresMascota = new ArrayList<>();
        for (Mascota mascota : mascotas) {
            nombresMascota.add(mascota.getNombre());
        }

        return v;
    }
    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.cat, "Maumau"));
        mascotas.add(new Mascota(R.drawable.dog, "Peche"));
        mascotas.add(new Mascota(R.drawable.hamster, "Jonstor"));
        mascotas.add(new Mascota(R.drawable.rabbit, "Coner"));
        mascotas.add(new Mascota(R.drawable.lovebird, "Rito"));
    }
}


