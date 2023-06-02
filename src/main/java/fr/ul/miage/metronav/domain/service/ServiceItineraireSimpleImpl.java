package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.*;
/**
 * Implémentation du service d'itinéraire le plus simple.
 */
public class ServiceItineraireSimpleImpl extends PathFinder implements ServiceItineraireSimple{
    /**
     * Calcule de l'itinéraire le plus simple entre une station de départ et une station d'arrivée.
     *
     * @param stationDepart La station de départ.
     * @param stationArrivee La station d'arrivée.
     * @param stationList La liste des stations disponibles.
     * @param trajetList La liste des trajets disponibles.
     * @return Un objet Itineraire représentant le chemin à suivre.
     */
    @Override
    public Itineraire calculerItineraireSimple(Station stationDepart , Station stationArrivee, List<Station> stationList, List<Trajet> trajetList) {
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> previousStations = new HashMap<>();
        Set<Station> visitedStations = new HashSet<>();

        PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        distances.put(stationDepart, 0);
        queue.offer(stationDepart);

        while (!queue.isEmpty()) {
            Station currentStation = queue.poll();
            visitedStations.add(currentStation);

            for (Station neighborStation : getNeighborStation(currentStation, trajetList)) {
                if (neighborStation.isSafe()) {

                    if (!visitedStations.contains(neighborStation)) {//Si la station n'as pas deja été traverser

                        int lineChangeTrajet = sameLine(getTrajet(previousStations.get(currentStation), currentStation, trajetList),getTrajet(currentStation, neighborStation, trajetList))? 0 : 1;

                        int newDistance = distances.get(currentStation) + lineChangeTrajet;//on augmente la valeur de la distance de la station courrante

                        if (!distances.containsKey(neighborStation) || newDistance < distances.get(neighborStation)) {
                            distances.put(neighborStation, newDistance);
                            previousStations.put(neighborStation, currentStation);
                            queue.offer(neighborStation);
                        }
                    }
                }
            }
        }

        List<Station> itineraireStation = buildPath(previousStations, stationArrivee);
        Collections.reverse(itineraireStation);
        return stationListToItineraire(itineraireStation, trajetList);
    }
    /**
     * Génère l'itinéraire à partir du plus court chemin et de la liste des trajets.
     * @param previousStations Les stations précédentes.
     * @param station          La station d'arrivée.
     * @return Une liste de stations représentant le chemin.
     */
    private List<Station> buildPath(Map<Station, Station> previousStations, Station station) {
        List<Station> path = new ArrayList<>();
        Station currentStation = station;

        while (currentStation != null) {
            path.add(currentStation);
            System.out.println(currentStation);
            currentStation = previousStations.get(currentStation);
        }

        return path;
    }

    /**
     * Récupère les stations voisines d'une station donnée à partir de la liste des trajets disponibles.
     *
     * @param station     La station donnée.
     * @param trajetList  La liste des trajets disponibles.
     * @return Une liste de stations voisines.
     */
    private List<Station> getNeighborStation(Station station, List<Trajet> trajetList) {
        List<Station> neighborList = new ArrayList<>();

        for (Trajet trajet : trajetList) {
            if (trajet.isSafe() && isStationMatch(station, trajet)) {
                Station neighborStation = getNeighborStationFromTrajet(station, trajet);
                neighborList.add(neighborStation);
            }
        }

        return neighborList;
    }

    /**
     * Vérifie si une station donnée correspond à une station de départ ou une station d'arrivée dans un trajet.
     *
     * @param station La station donnée.
     * @param trajet  Le trajet à vérifier.
     * @return true si la station correspond à une station de départ ou d'arrivée du trajet, sinon false.
     */
    private boolean isStationMatch(Station station, Trajet trajet) {
        return trajet.getStationDepart().equals(station) || trajet.getStationArrivee().equals(station);
    }

    /**
     * Récupère la station voisine d'une station donnée à partir d'un trajet.
     *
     * @param station La station donnée.
     * @param trajet  Le trajet.
     * @return La station voisine.
     */
    private Station getNeighborStationFromTrajet(Station station, Trajet trajet) {
        return trajet.getStationDepart().equals(station) ? trajet.getStationArrivee() : trajet.getStationDepart();
    }

    /**
     * Récupère le trajet entre deux stations données.
     *
     * @param stationX     La première station.
     * @param stationY     La deuxième station.
     * @param trajetList   La liste des trajets disponibles.
     * @return Le trajet entre les deux stations, ou null si aucun trajet n'est trouvé.
     */
    private Trajet getTrajet(Station stationX, Station stationY, List<Trajet> trajetList) {
        for (Trajet trajet : trajetList) {
            if (trajet.getStationArrivee().equals(stationX) && trajet.getStationDepart().equals(stationY)) {
                return trajet;
            } else if (trajet.getStationDepart().equals(stationX) && trajet.getStationArrivee().equals(stationY)) {
                return trajet;
            }
        }
        return null;
    }

    /**
     * Vérifie si deux trajets sont sur la même ligne.
     *
     * @param precedent Le trajet précédent.
     * @param courant   Le trajet courant.
     * @return true si les trajets sont sur la même ligne, sinon false.
     */
    boolean sameLine(Trajet precedent, Trajet courant){
        boolean sameLigne = false;

        if (precedent != null) {
            for (Ligne l : precedent.getLignes()) {
                if (courant.getLignes().contains(l)) {
                    sameLigne = true;
                    break;
                }
            }
        }else{
            sameLigne = true;
        }
        return sameLigne;
    }
}
