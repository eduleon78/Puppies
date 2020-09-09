package com.leonestudios.puppies;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;
    public Contacto contac;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder ContactoViewholder, int position) {
        final Contacto contacto = contactos.get(position);
        ContactoViewholder.imgFoto.setImageResource(contacto.getFoto());
        ContactoViewholder.tvNombreCV.setText(contacto.getNombre());
        ContactoViewholder.tvTelefonoCV.setText(contacto.getTelefono());
        ContactoViewholder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                contac = new Contacto(contacto.getNombre(), contacto.getTelefono(), contacto.getEmail(), contacto.getFoto());
                intent.putExtra("my contact", contac);
                activity.startActivity(intent);
            }
        });
        ContactoViewholder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return contactos.size();
    }
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefono);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);


        }
    }
}


