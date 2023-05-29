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
import java.util.Objects;

public class ServiceItineraireImpl implements ServiceItineraire {
    @Override
    public Itineraire calculerItineraireRapide(Station depart, Station arrivee, List<Station> stationList, List<Trajet> trajetList) {
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);


        for (Trajet trajet : trajetList) {
            if (Objects.equals(trajet.getStationArrivee().getIncident(), "") && Objects.equals(trajet.getStationDepart().getIncident(), "") && Objects.equals(trajet.getIncident(), "")) {
                if (!metroGraph.containsVertex(trajet.getStationDepart())) {
                    metroGraph.addVertex(trajet.getStationDepart());
                    System.out.println(trajet.getStationDepart());
                }
                if (!metroGraph.containsVertex(trajet.getStationArrivee())) {
                    metroGraph.addVertex(trajet.getStationArrivee());
                    System.out.println(trajet.getStationArrivee());
                }

                String nom_depart = trajet.getStationArrivee().getNom().substring(8) + trajet.getStationDepart().getNom().substring(8);
                String nom_arrivee = trajet.getStationDepart().getNom().substring(8) + trajet.getStationArrivee().getNom().substring(8);

                Station station_poid_arrivee = new Station(nom_depart, trajet.getStationArrivee().getPosition(), trajet.getStationArrivee().getTemps_arret() / 2, trajet.getStationArrivee().getLignes(), trajet.getStationArrivee().getIncident());
                Station station_poid_depart = new Station(nom_arrivee, trajet.getStationDepart().getPosition(), trajet.getStationDepart().getTemps_arret() / 2, trajet.getStationDepart().getLignes(), trajet.getStationDepart().getIncident());

                metroGraph.addVertex(station_poid_arrivee);
                metroGraph.addVertex(station_poid_depart);

                DefaultWeightedEdge edge_poid1 = metroGraph.addEdge(station_poid_arrivee, trajet.getStationArrivee());
                metroGraph.setEdgeWeight(edge_poid1, station_poid_arrivee.getTemps_arret());
                DefaultWeightedEdge edge_poid2 = metroGraph.addEdge(station_poid_depart, trajet.getStationDepart());
                metroGraph.setEdgeWeight(edge_poid2, station_poid_arrivee.getTemps_arret());
                DefaultWeightedEdge edge1 = metroGraph.addEdge(station_poid_depart, station_poid_arrivee);
                metroGraph.setEdgeWeight(edge1, trajet.getDuree());

            }
        }

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
        Graph<Station, DefaultWeightedEdge> metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);


        for (Trajet trajet : trajetList) {
            if (Objects.equals(trajet.getStationArrivee().getIncident(), "") && Objects.equals(trajet.getStationDepart().getIncident(), "") && Objects.equals(trajet.getIncident(), "")) {
                if (!metroGraph.containsVertex(trajet.getStationDepart())) {
                    metroGraph.addVertex(trajet.getStationDepart());
                    System.out.println(trajet.getStationDepart());
                }
                if (!metroGraph.containsVertex(trajet.getStationArrivee())) {
                    metroGraph.addVertex(trajet.getStationArrivee());
                    System.out.println(trajet.getStationArrivee());
                }

                String nom_depart = trajet.getStationArrivee().getNom().substring(8) + trajet.getStationDepart().getNom().substring(8);
                String nom_arrivee = trajet.getStationDepart().getNom().substring(8) + trajet.getStationArrivee().getNom().substring(8);

                Station station_poid_arrivee = new Station(nom_depart, trajet.getStationArrivee().getPosition(), trajet.getStationArrivee().getTemps_arret() / 2 , trajet.getStationArrivee().getLignes(), trajet.getStationArrivee().getIncident());
                Station station_poid_depart = new Station(nom_arrivee, trajet.getStationDepart().getPosition(), trajet.getStationDepart().getTemps_arret() / 2, trajet.getStationDepart().getLignes(), trajet.getStationDepart().getIncident());

                metroGraph.addVertex(station_poid_arrivee);
                metroGraph.addVertex(station_poid_depart);

                DefaultWeightedEdge edge_poid1 = metroGraph.addEdge(station_poid_arrivee, trajet.getStationArrivee());
                metroGraph.setEdgeWeight(edge_poid1, station_poid_arrivee.getTemps_arret());
                DefaultWeightedEdge edge_poid2 = metroGraph.addEdge(station_poid_depart, trajet.getStationDepart());
                metroGraph.setEdgeWeight(edge_poid2, station_poid_arrivee.getTemps_arret());
                DefaultWeightedEdge edge1 = metroGraph.addEdge(station_poid_depart, station_poid_arrivee);
                metroGraph.setEdgeWeight(edge1, trajet.getDuree());

            }
        }

        // Création de l'algorithme A*
        ShortestPathAlgorithm<Station, DefaultWeightedEdge> shortestPathAlgorithm = new AStarShortestPath<>(metroGraph, new CustomHeuristic<Station>(metroGraph));

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


}
