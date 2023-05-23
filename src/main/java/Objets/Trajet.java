package main.java.Objets;

public class Trajet {

    private Station stationDepart;
    private Station stationArrivee;
    private int duree;

    public Trajet(Station station_depart, Station station_arrivee, int duree) {
        this.stationDepart = station_depart;
        this.stationArrivee = station_arrivee;
        this.duree = duree;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public Station getStationArrivee() {
        return stationArrivee;
    }

    public int getDuree() {
        return duree;
    }
}
