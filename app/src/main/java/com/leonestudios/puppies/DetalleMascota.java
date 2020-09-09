package com.leonestudios.puppies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DetalleMascota extends AppCompatActivity {
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    public Contacto contacto;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistableBundle) {
        super.onCreate(savedInstanceState, persistableBundle);
        setContentView(R.layout.activity_detalle_mascota);

        agregarFAB();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleMascota.this, ListadoMascota.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void llamar(View v){
        String telefono = tvTelefono.getText().toString();
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }
    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
    public void agregarFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(android.R.id.content),"diste click al boton flotante",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}