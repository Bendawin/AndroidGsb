//fonctionnel

package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChoixActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);

        // création des variables
        Button btnlistepraticiens;
        Button btnlistemedicaments;
        Button btnlistevisiteurs;
        Button btnlistepatients;

        //récupération par id
        btnlistepatients = (Button) findViewById(R.id.btnlistepatients);
        btnlistemedicaments = (Button) findViewById(R.id.btnlistemedicaments);
        btnlistevisiteurs = (Button) findViewById(R.id.btnlistevisiteurs);
        btnlistepraticiens = (Button) findViewById(R.id.btnlistepraticiens);

        //Quand on clic
        btnlistepatients.setOnClickListener(this);
        btnlistemedicaments.setOnClickListener(this);
        btnlistevisiteurs.setOnClickListener(this);
        btnlistepraticiens.setOnClickListener(this);
    }

    //traitement du clic
    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.btnlistepatients: // Quand on clique sur btnpatients, popup erreur
                Toast.makeText(getApplicationContext(), "Service en cours de développement. Veuillez nous excusez pour la gène occasionné.",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnlistemedicaments: // Quand on clique sur btnlistemedicaments, popup erreur
                Toast.makeText(getApplicationContext(), "Service en cours de développement. Veuillez nous excusez pour la gène occasionné.",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnlistevisiteurs: // Quand on clique sur btnlistevisiteurs, popup erreur
                Toast.makeText(getApplicationContext(), "Service en cours de développement. Veuillez nous excusez pour la gène occasionné.",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnlistepraticiens: // Quand on clique sur btnlistepraticiens, envoi sur DepartementsActivity
                startActivity(new Intent(this, DepartementsActivity.class));
                break;
        }
    }
}
