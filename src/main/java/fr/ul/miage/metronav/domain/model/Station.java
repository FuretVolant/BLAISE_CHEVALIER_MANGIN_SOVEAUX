package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;


public class Station {

    private String nom;

    private int temps_arret;

    private List<Ligne> lignes;

    private String incident;

    private Position position;

    public Station(String nom, Position position, int temps_arret, List<Ligne> lignes, String incident) {
        this.nom = nom;
        this.position = position;
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
        return this.incident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(nom, station.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return this.getNom() + " : " + this.getTemps_arret();
    }
}
