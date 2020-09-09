package com.leonestudios.puppies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
    public class Contacto implements Serializable {
        private String nombre;
        private String telefono;
        private String email;
        private int foto;

        public Contacto(String nombre, String telefono, String email, int foto) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
            this.foto = foto;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getEmail() {
            return email;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getFoto() {
            return foto;
        }

        public void setFoto(int foto) {
            this.foto = foto;
        }

    }
