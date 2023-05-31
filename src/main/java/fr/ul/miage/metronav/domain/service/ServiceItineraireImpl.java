package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class ServiceItineraireImpl implements ServiceItineraire {
    @Override
    public Itineraire calculerItineraireRapide(Station depart, Station arrivee, List<Station> stationList, List<Trajet> trajetList) {
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph =generateGraph(stationList, trajetList);

        // Création de l'algorithme A*
        ShortestPathAlgorithm<Station, DefaultWeightedEdge> shortestPathAlgorithm = new DijkstraShortestPath<>(metroGraph);

        // Recherche de l'itinéraire optimal
        GraphPath<Station, DefaultWeightedEdge> shortestPath = shortestPathAlgorithm.getPath(depart, arrivee);

        // Affichage de l'itinéraire
        if (shortestPath != null) {
            System.out.println("Itinéraire optimal : " + shortestPath.getVertexList());
            System.out.println("Coût total : " + shortestPath.getWeight());
        } else {
            System.out.println("Aucun itinéraire trouvé.");
        }

        return generateItineraire(shortestPath,trajetList);
    }

    @Override
    public Itineraire calculerItineraireSimple(Station depart, Station arrivee, List<Station> stationList, List<Trajet> trajetList) {
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph = generateGraph(stationList, trajetList);
        // Création de l'algorithme A*
        ShortestPathAlgorithm<Station, DefaultWeightedEdge> shortestPathAlgorithm = new AStarShortestPath<>(metroGraph, new CustomHeuristic(metroGraph));

        // Recherche de l'itinéraire optimal
        GraphPath<Station, DefaultWeightedEdge> shortestPath = shortestPathAlgorithm.getPath(depart, arrivee);

        // Affichage de l'itinéraire
        if (shortestPath != null) {
            System.out.println("Itinéraire optimal : " + shortestPath.getVertexList());
            System.out.println("Coût total : " + shortestPath.getWeight());
        } else {
            System.out.println("Aucun itinéraire trouvé.");
        }

        return generateItineraire(shortestPath,trajetList);
    }

    private Itineraire generateItineraire(GraphPath<Station, DefaultWeightedEdge> shortestPath, List<Trajet> trajetList){
        List<Station> stationList = new ArrayList<>();
        List<Trajet> trajetListItineraire = new ArrayList<>();
        for (Station s: shortestPath.getVertexList()) {
            if(isArealStation(s)) {stationList.add(s);}
        }


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

    private boolean  isArealStation(Station s){
        return s.getNom().length()!= 2;
    }

    private String getStationID(Station station){
        return station.getNom().substring(8);
    }

    private Graph<Station, DefaultWeightedEdge> generateGraph(List<Station> stationList, List<Trajet> trajetList){
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (Station station: stationList) {
            metroGraph.addVertex(station);
        }


        for (Trajet trajet : trajetList) {

            Station stationArrivee = trajet.getStationArrivee();
            Station stationDepart = trajet.getStationDepart();

            if (stationArrivee.isSafe() && stationDepart.isSafe() && trajet.isSafe()) {

                String nom_depart_poid = getStationID(stationArrivee) + getStationID(stationDepart);
                String nom_arrivee_poid = getStationID(stationDepart) + getStationID(stationArrivee);

                Station station_poid_arrivee = new Station(nom_depart_poid, stationArrivee.getPosition(), stationArrivee.getTemps_arret() / 2 , trajet.getLignes(), stationArrivee.getIncident());
                Station station_poid_depart = new Station(nom_arrivee_poid,stationDepart.getPosition(), stationDepart.getTemps_arret() / 2, trajet.getLignes(), stationDepart.getIncident());

                metroGraph.addVertex(station_poid_arrivee);
                metroGraph.addVertex(station_poid_depart);

                DefaultWeightedEdge edge_poid_arrive = metroGraph.addEdge(station_poid_arrivee, stationArrivee);
                metroGraph.setEdgeWeight(edge_poid_arrive, station_poid_arrivee.getTemps_arret());

                DefaultWeightedEdge edge_poid_depart = metroGraph.addEdge(station_poid_depart, stationDepart);
                metroGraph.setEdgeWeight(edge_poid_depart, station_poid_arrivee.getTemps_arret());

                DefaultWeightedEdge edge = metroGraph.addEdge(station_poid_depart, station_poid_arrivee);
                metroGraph.setEdgeWeight(edge, trajet.getDuree());

            }

        }
        return metroGraph;
    }
}
