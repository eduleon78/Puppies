package com.leonestudios.puppies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public MascotaAdaptador adaptadormascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listamascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llmmascotas = new LinearLayoutManager(this);
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
        inicializarListaMascotas();
        inicializarAdaptador();

        lstMiLista = (ListView) findViewById(R.id.lstMilista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContendido();
            }
        });
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();

    }
    public void inicializarAdaptador(){
        adaptadormascota = new MascotaAdaptador(mascotas, this);
        listamascotas.setAdapter(adaptadormascota);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tobby", 2, R.drawable.tobby));
        mascotas.add(new Mascota("Leon", 4, R.drawable.leon));
        mascotas.add(new Mascota("Capitan", 5, R.drawable.capitan));
        mascotas.add(new Mascota("George", 1, R.drawable.george));
        mascotas.add(new Mascota("pluto", 3, R.drawable.pluto));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(MainActivity.this, ListaFavoritos.class);
                intent.putExtra("mymascotas", mascotas);
                startActivity(intent);
                finish();
                break;
            case R.id.mContacto:
                Intent intentc = new Intent(MainActivity.this, ListadoMascota.class);
                startActivity(intentc);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void refrescandoContendido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }
}