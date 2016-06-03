package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Nickname on 03/06/2016.
 */
public class PraticienAdapter {

    private List<Praticien> lesPraticiens;
    private Context c;

    PraticienAdapter(List<Praticien> data, Context c){
        this.lesPraticiens = data;
        this.c = c;
    }

    //getter
    public int getCount() {
        return lesPraticiens.size();
    }


    public Object getItem(int position) {
        return lesPraticiens.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.praticien, null);

        TextView nom = (TextView) v.findViewById(R.id.nom);
        TextView prenom = (TextView) v.findViewById(R.id.prenom);
        TextView adresse = (TextView) v.findViewById(R.id.adresse);
        TextView tel = (TextView) v.findViewById(R.id.tel);
        TextView specialite = (TextView) v.findViewById(R.id.specialite);

        Praticien lePraticien = lesPraticiens.get(position);
        nom.setText(lePraticien.getNom());
        prenom.setText(lePraticien.getPrenom());
        adresse.setText(lePraticien.getAdresse());
        tel.setText(lePraticien.getTel());
        specialite.setText(lePraticien.getSpecialite());

        return v;
    }


}
