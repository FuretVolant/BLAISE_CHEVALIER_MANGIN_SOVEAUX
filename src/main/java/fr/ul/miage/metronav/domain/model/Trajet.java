package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Représente un trajet entre deux stations.
 */
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

    /**
     * Constructeur de la classe Trajet sans incident.
     *
     * @param stationDepart  La station de départ du trajet.
     * @param stationArrivee La station d'arrivée du trajet.
     * @param duree          La durée du trajet en minutes.
     * @param lignes         La liste des lignes empruntées pour le trajet.
     */
    public Trajet(Station stationDepart, Station stationArrivee, int duree, List<Ligne> lignes) {
        this.stationDepart = stationDepart;
        this.stationArrivee = stationArrivee;
        this.duree = duree;
        this.incident = "";
        this.lignes = lignes;
    }

    /**
     * Constructeur de la classe Trajet avec incident.
     *
     * @param stationDepart  La station de départ du trajet.
     * @param stationArrivee La station d'arrivée du trajet.
     * @param duree          La durée du trajet en minutes.
     * @param incident       L'incident survenu pendant le trajet.
     * @param lignes         La liste des lignes empruntées pour le trajet.
     */
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

    /**
     * Vérifie si le trajet est sans incident.
     *
     * @return true si le trajet est sans incident, false sinon.
     */
    public boolean isSafe(){
        return Objects.equals(incident, "");
    }

    /**
     * Vérifie si le trajet est égal à un autre objet.
     *
     * @param o L'objet à comparer.
     * @return true si les trajets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trajet trajet = (Trajet) o;
        return Objects.equals(stationDepart, trajet.stationDepart) && Objects.equals(stationArrivee, trajet.stationArrivee);
    }
}
