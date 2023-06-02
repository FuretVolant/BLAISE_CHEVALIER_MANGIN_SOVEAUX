package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite pour rechercher un chemin.
 */
abstract public class PathFinder {

    /**
     * Convertit une liste de stations et une liste de trajets en un itinéraire.
     *
     * @param stationList La liste des stations à parcourir.
     * @param trajetList  La liste des trajets disponibles.
     * @return Un objet Itineraire représentant le chemin à suivre.
     */
    public Itineraire stationListToItineraire(List<Station> stationList, List<Trajet> trajetList){

        List<Trajet> trajetListItineraire = new ArrayList<>();

        for (int i = 0; stationList.size() > i ; i++) {
            if(i >= 1){
                for (Trajet trajet : trajetList) {
                    if(trajet.getStationArrivee().equals(stationList.get(i)) && trajet.getStationDepart().equals(stationList.get(i-1))){
                        trajetListItineraire.add(trajet);
                    }else if(trajet.getStationDepart().equals(stationList.get(i)) && trajet.getStationArrivee().equals(stationList.get(i-1))){
                        trajetListItineraire.add(trajet);
                    }
                }}
        }

        return new Itineraire(trajetListItineraire);


    }
}
