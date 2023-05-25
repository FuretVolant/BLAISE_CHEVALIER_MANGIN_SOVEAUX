package fr.ul.miage.metronav.domain.model;

public class Trajet {

    private Station station_depart;
    private Station station_arrivee;
    private int duree;

    public Trajet(Station stationDepart, Station stationArrivee, int duree) {
        station_depart = stationDepart;
        station_arrivee = stationArrivee;
        this.duree = duree;
    }
}
