package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Représente une station de métro.
 */
public class Station {

    private String nom;

    private int temps_arret;

    private List<Ligne> lignes;

    private String incident;

    private Position position;

    /**
     * Constructeur de la classe Station.
     *
     * @param nom         Le nom de la station.
     * @param position    La position géographique de la station.
     * @param temps_arret Le temps d'arrêt en minutes à la station.
     * @param lignes      La liste des lignes desservant la station.
     * @param incident    Incident éventuel survenu à la station.
     */
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

    /**
     * Vérifie si la station est égale à un autre objet.
     *
     * @param o L'objet à comparer.
     * @return true si les stations sont égales, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(nom, station.nom);
    }

    /**
     * Calcule le code de hachage de la station.
     *
     * @return Le code de hachage de la station.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    public Position getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return this.getNom();
    }

    /**
     * Vérifie si la station est sans incident.
     *
     * @return true si la station est sans incident, false sinon.
     */
    public boolean isSafe(){
        return Objects.equals(incident, "");
    }
}
