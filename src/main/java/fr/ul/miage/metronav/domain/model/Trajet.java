package fr.ul.miage.metronav.domain.model;

public class Trajet {

    private Station stationDepart;
    private Station stationArrivee;
    private int duree;

    private String incident;

    public Trajet(Station stationDepart, Station stationArrivee, int duree) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
        this.incident = "";
    }

    public Trajet(Station stationDepart, Station stationArrivee, int duree, String incident) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
        this.incident = incident;
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
}
