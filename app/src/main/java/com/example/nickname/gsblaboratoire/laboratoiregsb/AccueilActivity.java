//fonctionnel

package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // Création des variables

         Button btnentrer; // Button pour acceder au contenu

        //récupération par ID

        btnentrer = (Button) findViewById(R.id.btnentrer);

        //action via this lors du clic
        btnentrer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.btnentrer: // Quand on clique sur btnentrer, l'application lance l'activité ChoixActivity
                startActivity(new Intent(this, ChoixActivity.class));
                break;
        }
    }
}
