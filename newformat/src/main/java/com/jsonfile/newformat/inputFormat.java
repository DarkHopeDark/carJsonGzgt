package com.jsonfile.newformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class inputFormat {

    String brand;
    String model;
    String version;
    String hauteur;
    String longueur;
    String largeur;
    String poids_brut;

    public inputFormat() {
    }

    public inputFormat(String brand, String model, String version, String hauteur, String longueur, String largeur,
            String poids_brut) {
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.poids_brut = poids_brut;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public String getLongueur() {
        return longueur;
    }

    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    public String getLargeur() {
        return largeur;
    }

    public void setLargeur(String largeur) {
        this.largeur = largeur;
    }

    public String getPoidsBrute() {
        return poids_brut;
    }

    public void setPoidsBrute(String poidsBrute) {
        this.poids_brut = poidsBrute;
    }

}
