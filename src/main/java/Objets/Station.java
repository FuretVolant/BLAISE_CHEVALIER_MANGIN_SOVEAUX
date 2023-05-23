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
}
