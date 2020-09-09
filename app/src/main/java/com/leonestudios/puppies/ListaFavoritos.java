package com.leonestudios.puppies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.ArrayList;

public class ListaFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listafavoritos;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listafavoritos = (RecyclerView) findViewById(R.id.rvMascotasFav);
        LinearLayoutManager llmFavoritos = new LinearLayoutManager(this);
        llmFavoritos.setOrientation(LinearLayoutManager.VERTICAL);
        listafavoritos.setLayoutManager(llmFavoritos);

        Intent intent = getIntent();
        mascotas = (ArrayList<Mascota>) intent.getSerializableExtra("Mi Mascota");
        iniciarAdaptador();

    }
    public void iniciarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, this);
        listafavoritos.setAdapter(adaptador);

    }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK){
                Intent intent = new Intent(ListaFavoritos.this, MainActivity.class);
                startActivity(intent);
            }
            return super.onKeyDown(keyCode, event);

    }

}