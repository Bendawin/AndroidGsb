package com.example.nickname.gsblaboratoire.laboratoiregsb;

/**
 * Created by Nickname on 03/06/2016.
 */
public class Praticien {

    // création des variables
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String specialite;

    //constructeur
    Praticien(String nom, String prenom, String adresse, String tel, String specialite){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        if(specialite.equals("")){
            specialite = "Non renseigné";
        }
        this.specialite = specialite;
    }

    //getter
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public String getAdresse() { return this.adresse; }
    public String getTel() { return this.tel; }
    public String getSpecialite() { return this.specialite; }

    //créer une chaine avec les données du praticien
    static public String lachaine(Praticien lePrat){
        String chaine = lePrat.getNom() + "_" + lePrat.getPrenom() + "_" + lePrat.getAdresse() + "_" + lePrat.getTel() + "_" + lePrat.getSpecialite();
        return chaine;
    }

    //découpe la chaine de données
    static public Praticien coupelachaine(String chaine){
        String[] coupechaine = chaine.split("_");
        return new Praticien(coupechaine[0], coupechaine[1], coupechaine[2], coupechaine[3], coupechaine[4]);
    }

}
