package fr.ul.miage.metronav.domain.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
/**
 *Itinéraire composé de plusieurs trajets.
 */
public class Itineraire {

    private List<Trajet> trajetList;

    public Itineraire(List<Trajet> trajetList) {
        this.trajetList = trajetList;

    }

    public Itineraire() {

    }

    public void ajoutTrajet(Trajet trajet){
        trajetList.add(trajet);
    }


    /**
     * Calcule la durée totale de l'itinéraire.
     *
     * @return La durée totale de l'itinéraire en minutes.
     */
    public int getTempsTotal(){
        int res = 0;
        for (Trajet t : trajetList) {
            res+=t.getDuree();
            res+=t.getStationArrivee().getTemps_arret();
        }
        return res;
    }

    public List<Trajet> getTrajetList() {
        return trajetList;
    }

    /**
     * Calcule l'heure d'arrivée estimée de l'itinéraire.
     *
     * @return Une chaîne de caractères représentant l'heure d'arrivée estimée.
     */
    public String getHeureArrivee(){
        LocalTime heureActuelle = LocalTime.now();
        LocalTime heureArrivee = heureActuelle.plusMinutes(getTempsTotal());
        return heureArrivee.toString();
    }
}