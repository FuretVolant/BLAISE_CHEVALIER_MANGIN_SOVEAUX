package main.java.Objets;

import java.util.List;

public class Station {

    private String nom;

    private int temps_arret;

    private List<Ligne> lignes;

    private Incident incident;

    public Station(String nom, int temps_arret, List<Ligne> lignes, Incident incident) {
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

    public Incident getIncident() {
        return incident;
    }
}
