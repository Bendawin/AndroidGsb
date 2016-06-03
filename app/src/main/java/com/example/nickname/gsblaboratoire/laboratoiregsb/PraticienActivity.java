package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class PraticienActivity extends AppCompatActivity {


    //création des variables
    private String numDepartement;
    private TextView affichenumdep;
    private ArrayList<Praticien> listePraticien;
    private ListView lvpraticiens;
    private EditText filterBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticien);

        //gestion du numDepartement / affichage dans le TV affichenumdep
        Intent intent = getIntent();
        numDepartement = intent.getStringExtra("numDepartement");
        affichenumdep = (TextView)findViewById(R.id.affichenumdep);
        affichenumdep.setText(affichenumdep.getText() + " " + numDepartement + " :");


        //TEST MODULE RECHERCHE
        filterBox = (EditText)findViewById(R.id.editText);
        filterBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(listePraticien != null){
                    List<Praticien> listPraticienFiltered = new ArrayList<Praticien>();
                    for(Praticien lePraticien : listePraticien){
                        String nomprenom = lePraticien.getNom().toLowerCase();
                        if(nomprenom.contains(s.toString().toLowerCase())){
                            listPraticienFiltered.add(lePraticien);
                        }
                    }
                    affichList(listPraticienFiltered);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        //traitement de la LV lvpraticiens
        lvpraticiens = (ListView)findViewById(R.id.lvpraticiens);
        lvpraticiens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Praticien lePraticien = (Praticien) parent.getItemAtPosition(position);
                Intent intent = new Intent(PraticienActivity.this, ViewPraticienActivity.class);
                intent.putExtra("lePraticien", Praticien.lachaine(lePraticien));
                startActivity(intent);
            }
        });

        new voirPraticien().execute();
    }
    //affiche liste praticien
    private void getPraticien(List<Praticien> listePrat){
        listePraticien = new ArrayList<Praticien>(listePrat);
        affichList(listePraticien);
    }

    //affiche liste praticien
    private void affichList(List<Praticien> lesPraticiens){
        PraticienAdapter adapter = new PraticienAdapter(lesPraticiens, PraticienActivity.this);
        lvpraticiens.setAdapter(adapter);
    }

    //cherche les praticiens par rapport au numéro département
    private class voirPraticien extends AsyncTask<Void, Void, Void> {

        List<Praticien> lesPraticiens;

        protected Void doInBackground(Void... params){
            lesPraticiens = traitement.getLesPrats(numDepartement);
            return null;
        }

        protected void onPostExecute(Void result){
            getPraticien(lesPraticiens);
        }
    }
}
