package com.example.listaexpandible4conmiproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdaptadorListaExp mAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se obtienen e inicializan las vistas.
        initVistas();

    }

    // Obtiene e inicializa las vistas.
    private void initVistas() {
        ExpandableListView listaExp = (ExpandableListView) this.findViewById(R.id.lstAlumnos);
        // No se usarán los indicadores por defecto para grupos e hijos.
        if (listaExp != null) {
            listaExp.setGroupIndicator(null);
            listaExp.setChildIndicator(null);
            // Se obtienen los datos.
            ArrayList<GrupoPadre> grupos = new ArrayList<>();
            ArrayList<ArrayList<GrupoHijo>> hijos = new ArrayList<>();
            fillDatos(grupos, hijos);
            // Se crea el adaptador para la lista y se establece.
            mAdaptador = new AdaptadorListaExp(this, grupos, hijos);
            listaExp.setAdapter(mAdaptador);
            // para escuchar los clicks de los hijos
//            listaExp.setOnChildClickListener(this);
            //para escuchar los click de los items
            listaExp.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    // Se obtiene el hijo pulsado.
                    GrupoHijo GHijo = mAdaptador.getChild(groupPosition, childPosition);
                    // toas con la informacion que pulso el usuario o hijo que pulso
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.info)+GHijo.getMontoHijo()+
                            GHijo.getDescripcionHijo()+GHijo.getFechaHijo(), Toast.LENGTH_SHORT).show();
                    // Se retorna true para indicar que el evento ya ha sido gestionado.
                    return true;
                }
            });
        }
    }

    // Obtiene los ArrayList de datos para grupos e hijos. Modifica los
    // parámetros recibidos.
    private void fillDatos(ArrayList<GrupoPadre> grupos,
                           ArrayList<ArrayList<GrupoHijo>> hijos) {

        //Recordar que hay que llenarlo mediante la bd con do while :)
        // recordar hacer las condiciones para que musestre por dia fecha quincena o mes
        ArrayList<GrupoPadre> grupoP;
        ArrayList<GrupoHijo> grupoActual;
        // Primer grupo.
        grupos.add(new GrupoPadre(R.drawable.s4,"Casa", 300));
        grupoActual = new ArrayList<>();
        grupoActual.add(new GrupoHijo(10, "Empanadas", "25/05/2020"));
        grupoActual.add(new GrupoHijo(5, "Gaseosa", "25/05/2020"));
        grupoActual.add(new GrupoHijo(50, "Queso", "25/05/2020"));
        hijos.add(grupoActual);

        // Segundo grupo.
        // esta es para prueba con el new grupopadre
        grupos.add(new GrupoPadre(R.drawable.flecha16_arriba,"Casa", 100));
        grupoActual = new ArrayList<>();
        grupoActual.add(new GrupoHijo(200, "frenos", "29/03/2020"));
        hijos.add(grupoActual);


    }



}
