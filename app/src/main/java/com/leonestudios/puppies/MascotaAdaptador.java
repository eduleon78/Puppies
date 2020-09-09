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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public Mascota mascota;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRating.setText(mascota.getRating() + "");
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rating = mascota.getRating();
                mascota.setRating( ++rating);
                mascotaViewHolder.tvRating.setText(String.valueOf(rating));
                Toast.makeText(activity, "Diste like a " + mascota.getNombre() + "Rating: " + mascota.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        private TextView tvRating;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto         = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCVM);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLikeCVM);
            tvRating        = (TextView)    itemView.findViewById(R.id.tvRatingCV);
        }
    }
}
