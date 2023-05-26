package fr.ul.miage.metronav.domain.model;

public class Trajet {

    private Station stationDepart;
    private Station stationArrivee;
    private int duree;

    public Trajet(Station stationDepart, Station stationArrivee, int duree) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
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
