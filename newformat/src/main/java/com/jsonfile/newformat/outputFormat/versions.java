package com.jsonfile.newformat.outputFormat;

public class versions {
    String name;
    String hauteur;
    String longueur;
    String largeur;
    String poidsBrute;

    public versions() {
    }

    public versions(String name, String hauteur, String longueur, String largeur, String poidsBrute) {
        this.name = name;
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.poidsBrute = poidsBrute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return poidsBrute;
    }

    public void setPoidsBrute(String poidsBrute) {
        this.poidsBrute = poidsBrute;
    }

}
