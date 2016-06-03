package com.example.nickname.gsblaboratoire.laboratoiregsb;

import android.content.Intent;
import android.provider.DocumentsContract;
import android.widget.Toast;

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

/**
 * Created by Nickname on 03/06/2016.
 */
public class traitement {

    //
    //info: document permet le traitement du html et du xml
    public static Document getDocumentUrl(String urldebase){
        URL monURL = null; //création d'une variable de type URL avec comme valeur null

        try{
            monURL = new URL(urldebase);
        }
        catch (MalformedURLException me)
        {
            // en cas d'erreur de l'url
        }

        ///////////////////////////////////////////////////////////////////////////////////

        //création de variables
        Document document = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try{
            db = dbf.newDocumentBuilder();
        }catch(ParserConfigurationException parseex){

            // en cas d'erreur

        }

        try{
            document = db.parse(monURL.openStream()); //openstream permet d'ouvrir une connexion
        }catch(IOException ioe){
        }catch(SAXException sax){
        }
        return document;


    }

    //permet de voir la liste des départements
    public static List<String> voirLesDepartements(){

        //url de base
        String urldebase = "http://gaemedecins.appspot.com/Controleur/medParDep/listeDep";

        //listeDeps est un nouveau arraylist de type string
        List<String> listeDeps = new ArrayList<String>();

        Document document = traitement.getDocumentUrl(urldebase);

        Element unElement = document.getDocumentElement(); // Element représente un éléments dans un fichier xml pouvant accueillir des attributs

        NodeList listeDepartements = unElement.getElementsByTagName("Departement");
        for (int i = 0; i < listeDepartements.getLength(); i++){
            Node departement = listeDepartements.item(i);
            NodeList lesProprietes = departement.getChildNodes();
            String num = "";
            for (int j = 0; j < lesProprietes.getLength(); j++){
                if(lesProprietes.item(j).getNodeName().equals("num")){
                    num += lesProprietes.item(j).getTextContent().trim();
                }
            }
            listeDeps.add(num);
        }
        return listeDeps;
    }

    public static List<Praticien> getLesPrats(String numDepartement){
        String url = "http://gaemedecins.appspot.com/Controleur/medParDep/listeMed/" + numDepartement;

        List<Praticien> theListe = new ArrayList<Praticien>();
        Document doc = traitement.getDocumentUrl(url);
        Element racine = doc.getDocumentElement();

        NodeList listePraticien = racine.getElementsByTagName("Praticien");
        for (int i = 0; i < listePraticien.getLength(); i++){
            Node praticien = listePraticien.item(i);
            NodeList lesProprietes = praticien.getChildNodes();
            String nom = "";
            String prenom = "";
            String tel = "";
            String specialite = "";
            String adresse = "";
            for (int j = 0; j < lesProprietes.getLength(); j++){
                if(lesProprietes.item(j).getNodeName().equals("nom")){
                    nom += lesProprietes.item(j).getTextContent().trim();
                }
                if(lesProprietes.item(j).getNodeName().equals("prenom")){
                    prenom += lesProprietes.item(j).getTextContent().trim();
                }
                if(lesProprietes.item(j).getNodeName().equals("tel")){
                    tel += lesProprietes.item(j).getTextContent().trim();
                }
                if(lesProprietes.item(j).getNodeName().equals("specialite")){
                    specialite += lesProprietes.item(j).getTextContent().trim();
                }
                if(lesProprietes.item(j).getNodeName().equals("adresse")){
                    adresse += lesProprietes.item(j).getTextContent().trim();
                }
            }
            theListe.add(new Praticien(nom, prenom, adresse, tel, specialite));
        }
        return theListe;
    }
}


