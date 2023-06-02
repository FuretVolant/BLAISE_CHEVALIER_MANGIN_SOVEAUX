package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.*;

public class ServiceItineraireSimpleImpl extends PathFinder implements ServiceItineraireSimple{
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

    private boolean isStationMatch(Station station, Trajet trajet) {
        return trajet.getStationDepart().equals(station) || trajet.getStationArrivee().equals(station);
    }

    private Station getNeighborStationFromTrajet(Station station, Trajet trajet) {
        return trajet.getStationDepart().equals(station) ? trajet.getStationArrivee() : trajet.getStationDepart();
    }

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
