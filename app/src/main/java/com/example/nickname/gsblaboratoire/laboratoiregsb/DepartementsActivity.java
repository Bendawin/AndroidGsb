//fonctionnel

package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DepartementsActivity extends AppCompatActivity {

    //création des variables
    private ListView lvdepartements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departements);

        //traitement de la LV via id
        lvdepartements = (ListView)findViewById(R.id.lvdepartements);
        //Quand on clic
        lvdepartements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DepartementsActivity.this, PraticienActivity.class);
                intent.putExtra("numDepartement", parent.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
        //execute voirDepartement
        new voirDepartement().execute();
    }

    // permet d'afficher la liste des départements
    private class voirDepartement extends AsyncTask<Void, Void, Void> {

        List<String> lesDeps;

        //en arrière plan
        protected Void doInBackground(Void... params){
            lesDeps = traitement.voirLesDepartements();
            return null;
        }

        // visible (liste visible)
        protected void onPostExecute(Void result){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(DepartementsActivity.this, android.R.layout.simple_list_item_1, lesDeps);
            lvdepartements.setAdapter(adapter);
        }
    }

}
