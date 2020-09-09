package com.leonestudios.puppies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ListadoMascota extends AppCompatActivity {
    public static final String EXTRA_NOMBRE = "";
    ArrayList<Contacto> contactos;
    private RecyclerView listadoContacto;
    public ContactoAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascota);

        listadoContacto = (RecyclerView)findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listadoContacto.setLayoutManager(llm);

    }
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listadoContacto.setAdapter(adaptador);
    }
    public void inicializarListaContacto(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Eduardo Leon", "04248587119", "eduleon78@gmail.com", R.drawable.pina));
        contactos.add(new Contacto("Sonyram Acosta", "04147941202", "sonyra@yahoo.com", R.drawable.manzana));
        contactos.add(new Contacto("Grecia Santoro", "0412794799", "grecia@gmail.com", R.drawable.pera));
        contactos.add(new Contacto("Leander Leon", "04127947949", "Leander@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Christian Leon", "04165972630", "Christia@gmail.com", R.drawable.banana));
        contactos.add(new Contacto("Clarissa Leon", "04248509991", "Clarissa@gmail.com", R.drawable.mushroom));

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ListadoMascota.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}