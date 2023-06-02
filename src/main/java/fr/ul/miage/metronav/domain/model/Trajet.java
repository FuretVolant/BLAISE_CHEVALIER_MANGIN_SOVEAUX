package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;

public class Trajet {

    private Station stationDepart;



    @Override
    public int hashCode() {
        return Objects.hash(stationDepart, stationArrivee);
    }

    private Station stationArrivee;
    private int duree;
    private String incident;
    private List<Ligne> lignes;

    public Trajet(Station stationDepart, Station stationArrivee, int duree, List<Ligne> lignes) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
        this.incident = "";
        this.lignes = lignes;
    }

    public Trajet(Station stationDepart, Station stationArrivee, int duree, String incident, List<Ligne> lignes) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
        this.incident = incident;
        this.lignes = lignes;
    }


    public Station getStationDepart() {
        return this.stationDepart;
    }

    public Station getStationArrivee() {
        return this.stationArrivee;
    }

    public int getDuree() {
        return duree;
    }

    public String getIncident() {
        return incident;
    }

    public List<Ligne> getLignes(){
        return this.lignes;
    }

    public String toString(){
        return "["+this.stationDepart + " : " + this.stationArrivee+"]";
    }

    public boolean isSafe(){
        return Objects.equals(incident, "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trajet trajet = (Trajet) o;
        return Objects.equals(stationDepart, trajet.stationDepart) && Objects.equals(stationArrivee, trajet.stationArrivee);
    }
}
