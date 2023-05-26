package fr.ul.miage.metronav.domain.model;

import java.util.List;


public class Station {

    private String nom;

    private int temps_arret;

    private List<Ligne> lignes;

    private String incident;

    public Station(String nom, int temps_arret, List<Ligne> lignes, String incident) {
        this.nom = nom;
        this.temps_arret = temps_arret;
        this.lignes = lignes;
        this.incident = incident;
    }

    public String getNom() {
        return nom;
    }

    public int getTemps_arret() {
        return temps_arret;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public String getIncident() {
        return incident;
    }
}
