package com.example.list_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearLista extends AppCompatActivity {

    private boolean[] switchHora;
    private boolean[] switchFecha;
    private boolean[] switchPresupuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_lista);
    }

    public void mostrarFecha(View view) {
        if (switchFecha[0]){view.setVisibility(View.INVISIBLE);
            switchFecha[0] = false;
        }
    }

    public void mostrarHora(View view) {
        if (switchHora[0]){view.setVisibility(View.INVISIBLE);
            switchHora[0] = false;
        }
    }

    public void mostrarPresupuesto(View view) {
        if (switchPresupuesto[0]){view.setVisibility(View.INVISIBLE);
            switchPresupuesto[0] = false;}
    }

    public void LaunchVerLista(View view) {
        Intent VerLista = new Intent (this, VerLista.class);
        startActivity(VerLista);
    }
}